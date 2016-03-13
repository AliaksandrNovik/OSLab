package OS.rfe.by.novik.disk;

import java.util.List;

import OS.rfe.by.novik.scheduled.ScheduledOperatrion;
import OS.rfe.by.novik.system.System;
import OS.rfe.by.novik.process.Process;

public class Disk {

	public STATE state;

	public int stateTime;

	public int warmupTime;

	public int seekTime;

	public int cooldownTime;

	public int transferRate;

	public int sleepTimeout;

	public int bytesToTransfer;

	public int bytesTransfered;

	public System system;

	public void setSystem(System system) {
		this.system = system;
	}

	public List<ScheduledOperatrion> scheduledOperationsList;

	public Disk(int warmUpTime, int seekTime, int coolDownTime, int transferRate, int sleepTimeout) {
		this.warmupTime = warmUpTime;
		this.seekTime = seekTime;
		this.cooldownTime = coolDownTime;
		this.transferRate = transferRate;
		this.sleepTimeout = sleepTimeout;
	}

	public void requestIO(Process process, int bytesToTransfer) {
		scheduledOperationsList.add(new ScheduledOperatrion(process, bytesToTransfer));
	}

	public void run() {
		switch(state){
		case IDLE:
			if(scheduledOperationsList.size() == 0){
				stateTime ++;
				goToNextState(sleepTimeout, STATE.COOLDOWN);
			}
			break;
		case SLEEP:
			if(scheduledOperationsList.size() == 0){
				state = STATE.WARMUP;
				stateTime = 0;
				ScheduledOperatrion scheduledOperation = scheduledOperationsList.get(0);
				bytesTransfered = scheduledOperation.getBytesToTransfer();
			}
			break;
		case WARMUP:
			stateTime++;
			goToNextState(warmupTime,STATE.SEEK);
			break;
		case COOLDOWN:
			stateTime++;
			goToNextState(cooldownTime, STATE.SLEEP);
			break;
		case SEEK:
			stateTime++;
			if(stateTime == seekTime){
				state = STATE.TRANSFER;
				bytesTransfered = 0;
			}
			break;
		case TRANSFER:
			bytesTransfered += transferRate;
			if(bytesTransfered > bytesToTransfer){
				state = STATE.IDLE;
				stateTime = 0;
				ScheduledOperatrion scheduledOperation = scheduledOperationsList.get(0);
				scheduledOperationsList.remove(0);
				system.onIoFinished(scheduledOperation.getProcessId());
				break;
			}
		}
		

	}

	public int getTransferRate(){
		return transferRate;
	}

	public  void goToNextState(int controlTime, STATE state)
	{
		if (stateTime == controlTime)
		{
			this.state = state;
			stateTime = 0;
		}
	}

}

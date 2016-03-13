package OS.rfe.by.novik.scheduled;

import OS.rfe.by.novik.process.Process;;
public class ScheduledOperatrion {
	public Process process;

	public int bytesToTransfer;

	public  ScheduledOperatrion(Process processed, int bytesToTransfer) {
		this.process = processed;
		this.bytesToTransfer = bytesToTransfer;
	}

	public Process getProcessId(){
		return process;
	}

	public int getBytesToTransfer() {
		return bytesToTransfer;
	}
}

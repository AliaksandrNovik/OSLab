package OS.rfe.by.novik.process;

import OS.rfe.by.novik.instruction.TYPE;
import OS.rfe.by.novik.program.Program;
import OS.rfe.by.novik.system.System;;

public class Process {
	public  System system;

	public Program program;

	public int ticksToRun;

	public boolean sleeping = false;

	public Process(System system, Program program){
		this.system = system;
		this.program = program;
	}

	public void run() {
		if(ticksToRun > 0){
			ticksToRun--;
		}else{
			if (program.getNextInstruction() != null){
				system.onProcessFinished(this);
			}else if(program.getNextInstruction().getType() == TYPE.CPU){
				ticksToRun = program.getNextInstruction().getAmount() -1;
			}else if(program.getNextInstruction().getType() == TYPE.IO){
				system.requestIO(this, program.getNextInstruction().getAmount());
				sleeping = true;
			}
		}

	}

	public double getTotalRuntimeEstimate() {
		return program.getTotalCPUInstructionsAmount() / system.getCPUFrequency() + 
				program.getTotalIOInstructionsAmount() / system.getDiskTransferRate();
	}

	public int getRemainingRuntimeEstimate() {
		return program.getRemainingCPUInstructionsAmount() / system.getCPUFrequency() + 
				program.getRemainingIOInstructionsAmount() / system.getDiskTransferRate();
	}

	public void awake() {
		sleeping = false;

	}

	public boolean isSleeping() {
		return sleeping;
	}
}

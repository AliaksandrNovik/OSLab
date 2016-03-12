package OS.rfe.by.novik.process;

import java.util.List;

import OS.rfe.by.novik.program.Program;

public class Process {
	public  List<System> listSystem;

	public List<Program> listProgram;

	public int ticksToRun;

	public boolean sleeping;

	public Process(List<System> listSystem, List<Program> listProgram){
		
	}

	public void run() {
	}

	public int getTotalRuntimeEstimate() {
		return 0;
	}

	public int getRemainingRuntimeEstimate() {
		return 0;
	}

	public void awake() {
	}

	public boolean isSleeping() {
		return true;
	}
}

package OS.rfe.by.novik.scheduler;

import java.util.List;

public class Scheduler {
	
	public System system;

	public List<Process> processes;

	public Scheduler() {
	}

	public void onIOFinished(Process process) {
	}

	public void onProcessFinished(Process process) {
	}

	public Process getNextProcess() {
		return null;
	}

	public void addProcess(Process process) {
		processes.add(process);
	}

	public int getProcessCount() {
		return 0;
	}
}

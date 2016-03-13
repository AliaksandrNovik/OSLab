package OS.rfe.by.novik.scheduler;

import java.util.List;
import OS.rfe.by.novik.process.Process;
import OS.rfe.by.novik.system.System;

public class Scheduler {
	
	public System system;

	public void setSystem(System system) {
		this.system = system;
	}

	public List<Process> processes;

	public Scheduler() {
	}

	public void onIOFinished(Process process) {
		process.awake();
	}

	public void onProcessFinished(Process process) {
		processes.remove(process);
	}

	public Process getNextProcess(Process process) {
		return processes.get(processes.indexOf(process)+ 1);
	}

	public void addProcess(Process process) {
		processes.add(process);
	}

	public int getProcessCount() {
		return processes.size();
	}
}

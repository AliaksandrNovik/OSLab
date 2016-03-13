package OS.rfe.by.novik.scheduler;

import java.util.ArrayList;
import java.util.List;

import OS.rfe.by.novik.process.Process;

public class FIFOScheduler extends Scheduler{

	public List<Process> processes;
	
	public FIFOScheduler() {
		processes = new ArrayList<Process>();
	}
	
	public void onIoFinished(Process process)
	{
		process.awake();
	}

	public void onProcessFinished(Process process)
	{
		processes.remove(process);
	}

	public void addProcess(Process process)
	{
		processes.add(process);
	}

	public void onIOFinished(Process process) {
		process.awake();
	}


	public Process getNextProcess(Process process) {
		return processes.get(processes.indexOf(process)+ 1);
	}


	public int getProcessCount() {
		return processes.size();
	}
}

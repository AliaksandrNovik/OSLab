package OS.rfe.by.novik.system;

import OS.rfe.by.novik.disk.Disk;
import OS.rfe.by.novik.processor.Processor;
import OS.rfe.by.novik.scheduler.Scheduler;
import OS.rfe.by.novik.user.User;

public class System {
	
	public User user;

	public Processor processor;

	public Disk disk;

	public Scheduler scheduler;

	public Process currentProcess;

	public int skippedTicks;

	public int skipTicks;

	public int tick;

	public System() {
	}

	public void init() {
	}

	public void run() {
	}

	public void onIOFinished(Process process) {
	}

	public int getCPUFrequency() {
		return 0;
	}

	public int getDiskTransferRate() {
		return 0;
	}

	public void onProcessFinished(Process process) {
	}

	public void requestIO(Process process, int amount) {
	}

	public void runProcess(Process process) {
	}

	public Process getCurrentProcess(){
		return currentProcess;
	}
}

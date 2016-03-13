package OS.rfe.by.novik.system;

import java.util.logging.Logger;

import OS.rfe.by.novik.disk.Disk;
import OS.rfe.by.novik.processor.Processor;
import OS.rfe.by.novik.scheduler.FIFOScheduler;
import OS.rfe.by.novik.user.User;
import OS.rfe.by.novik.process.Process;

public class System {

	public User user;

	public Processor processor;

	public Disk disk;

	public FIFOScheduler scheduller;

	public Process currentProcess;

	public int skippedTicks;

	public int skipTicks;

	public int tick;

	private static Logger log = Logger.getLogger(System.class.getName());

	public System() {
	}

	public void init(Processor processor, Disk disk, FIFOScheduler scheduller, User user) {
		this.processor = processor;
		processor.setSystem(this);

		this.disk = disk;
		disk.setSystem(this);

		this.scheduller = scheduller;
		scheduller.setSystem(this);

		this.user = user;
		user.setSystem(this);

		double skipTicks = 10e6 / processor.getFrequency();
		log.info("skip ticks " + skipTicks);
		tick = 0;


	}

	public void run() {
		int skippedTicks = 0;
		while (scheduller.getProcessCount() > 0 || !user.isFinished())
		{
			
			tick++;
			skippedTicks++;
			if (!((tick % 100) == 0))
			{
				disk.run();
			}

			if (skippedTicks == skipTicks)
			{
				processor.run();
				skippedTicks = 0;
			}
			user.run(tick);
		}


	}

	public void onIOFinished(Process process) {
	}

	public int getCPUFrequency() {
		return processor.getFrequency();
	}

	public int getDiskTransferRate() {
		return disk.getTransferRate();
	}

	public void onIoFinished(Process process)
	{
		scheduller.onIOFinished(process);
	}
	
	public void onProcessFinished(Process process) {
		scheduller.onProcessFinished(process);
	}

	public void requestIO(Process process, int amount) {
		disk.requestIO(process, amount);
		currentProcess = scheduller.getNextProcess(process);
		scheduller.addProcess(process);
		runProcess(process);
		
	}

	public void runProcess(Process process) {
		currentProcess = process;
	}

	public Process getCurrentProcess(){
		return currentProcess;
	}
}

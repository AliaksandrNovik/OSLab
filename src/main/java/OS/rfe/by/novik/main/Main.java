package OS.rfe.by.novik.main;

import OS.rfe.by.novik.disk.Disk;
import OS.rfe.by.novik.processor.Processor;
import OS.rfe.by.novik.scheduler.FIFOScheduler;
import OS.rfe.by.novik.user.User;
import OS.rfe.by.novik.system.System;;

public class Main {

	public static void main(String[] args){
		int frequency = 5000;
		Processor processor = new Processor(frequency);
		int warmUpTime = 100;
		int seekTime = 100;
		int coolDownTime = 100;
		int transferRate = 100;
		int sleepTimeout = 100;
		
		Disk disk = new Disk(warmUpTime, seekTime, coolDownTime, transferRate, sleepTimeout);
		FIFOScheduler scheduller = new FIFOScheduler();
	    int processToGenerate = 100;
	    int ratio = 50;
	    int minICPU = 0;
		int maxICPU = 50;
		int minIIO = 0;
		int maxIIO = 50 ;
		int minInstructions = 0;
		int maxInstructions = 100;
		
		User user = new User(processToGenerate, ratio, minICPU, maxICPU, minIIO, maxIIO, minInstructions, maxInstructions);
		System system = new System();
		system.init(processor, disk, scheduller, user);
		system.run();
	}

}

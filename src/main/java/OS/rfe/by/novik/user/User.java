package OS.rfe.by.novik.user;

import java.util.logging.Logger;

import OS.rfe.by.novik.instruction.Instruction;
import OS.rfe.by.novik.instruction.TYPE;
import OS.rfe.by.novik.process.Process;
import OS.rfe.by.novik.program.Program;
import OS.rfe.by.novik.system.System;

public class User {


	public  System system;
	
	public int processesGenerated;

	public int processesToGenerate;
	
	public boolean isFinished = false;
	
	public int ratio;
	
	int minICPU;
	int maxICPU;
	int minIIO;
	int maxIIO;
	int minInstructions;
	int maxInstructions;


	private static Logger log = Logger.getLogger(User.class.getName());
	
	public User(int processesToGenerate, int ratio, int minICPU, int maxICPU, int minIIO, int maxIIO,
			int minInstructions, int maxInstructions) {
		this.ratio = ratio;
		this.minICPU = minICPU;
		this.maxICPU = maxICPU;
		this.minIIO = minIIO;
		this.maxIIO = maxIIO;
		this.minInstructions = minInstructions;
		this.maxInstructions = maxInstructions;
		this.processesToGenerate = processesToGenerate;
	}

	public void run(int tick) {
	    log.info("Current tick is " + tick);

	    isFinished = (processesGenerated >= processesToGenerate) || isFinished;
		if (isFinished == false)
		{
			addProcess(ratio, minICPU, maxICPU, 
					minIIO, maxIIO, 
					minInstructions, maxInstructions);
			processesGenerated++;
		
		}else{
			int g = 15;
		}
	}

	public void setFinished() {
		isFinished = true;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void addProcess(int ratio, int minICPU, int maxICPU, int minIIO, int maxIIO, int minInstructions, int maxInstructions) {
		Program program = new Program();
		TYPE type = null;
		int instructionsCount = getRandomValueFrom(minInstructions, maxInstructions);
		for(int count = 0; count < instructionsCount; ++count){
			int commandTypeRatio = getRandomValueFrom(0, 100);
			int amount;
			if (commandTypeRatio > ratio){
				type = TYPE.IO;
				amount = getRandomValueFrom(minIIO, maxIIO);
			}else{
				type = TYPE.CPU;
				amount = getRandomValueFrom(minICPU, maxICPU);
			}
			program.addInstruction(new Instruction(type, amount));

		}
		log.info("Run process with program: total instrcutions: " + instructionsCount + " CPU instructions amount: "+ program.getTotalCPUInstructionsAmount()+
				" IO instructions amount: " + program.getTotalIOInstructionsAmount());
		program.setReady();
		system.runProcess(new Process(new System(), program));
	}

	public int getRandomValueFrom(int minValue, int maxValue){
		return minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
	}

	public void setSystem(System system) {
		this.system = system;
	}
}

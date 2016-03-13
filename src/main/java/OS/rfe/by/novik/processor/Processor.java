package OS.rfe.by.novik.processor;

import OS.rfe.by.novik.system.System;

import OS.rfe.by.novik.process.Process;

public class Processor {
	
	public System system;
	public int frequency;
	public Process process;

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Processor(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void run() {
		Process process = system.getCurrentProcess();
		if(process != null){
			process.run();
		}
	}
}

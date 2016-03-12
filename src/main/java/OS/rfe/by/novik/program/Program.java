package OS.rfe.by.novik.program;

import java.util.List;

import OS.rfe.by.novik.instruction.Instruction;

public class Program {

	public List<Instruction> listInstructions;

	public List<Instruction> nextInstruction;

	public boolean ready;

	public void Program() {
	}

	public List<Instruction> getNextInstruction() {
		return null;
	}

	public void addInstruction(Instruction newInstruction){
		listInstructions.add(newInstruction);
	}

	public void ready() {
	}

	public int getTotalCPUInstructionsAmount() {
		return 0;
	}

	public int getRemainingCPUInstructionsAmount() {
		return 0;
	}

	public int getTotalIOInstructionsAmount() {
		return 0;
	}

	public int getRemainingIOInstructionsAmount() {
		return 0;
	}
}

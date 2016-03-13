package OS.rfe.by.novik.program;

import java.util.ArrayList;
import java.util.List;

import OS.rfe.by.novik.instruction.Instruction;
import OS.rfe.by.novik.instruction.TYPE;

public class Program {

	public List<Instruction> listInstructions;

	public boolean ready;

	public Instruction currentInstruction;

	public Program() {
		listInstructions = new ArrayList<Instruction>();
	}

	public Instruction getNextInstruction() {
		return listInstructions.get(listInstructions.size() - 1);
	}

	public void addInstruction(Instruction newInstruction){
		if(!ready){
			listInstructions.add(newInstruction);
		}
	}

	public void setReady() {
		ready = true;
		if(listInstructions.size() != 0){
			currentInstruction = listInstructions.get(0);
		}
	}

	public int getAmount( TYPE type){
		int count = 0;
		for (Instruction instruction :listInstructions){
			if(instruction.getType() == type){
				count++;
			}
		}
		return count;
	}

	public int getTotalCPUInstructionsAmount() {
		return getAmount(TYPE.CPU);
	}

	public int getRemainingCPUInstructionsAmount() {
		return 1;
	}

	public int getTotalIOInstructionsAmount() {
		return getAmount(TYPE.IO);
	}

	public int getRemainingIOInstructionsAmount() {
		return 1;
	}
}

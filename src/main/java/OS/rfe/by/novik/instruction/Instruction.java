package OS.rfe.by.novik.instruction;

public class Instruction {

	public TYPE type;

	int amount;

	public Instruction( TYPE type, int amount) {
		this.type = type;
		this.amount = amount;
	}

	public  TYPE getType(){
		return type;
	}

	public int getAmount(){
		return amount;
	}
}

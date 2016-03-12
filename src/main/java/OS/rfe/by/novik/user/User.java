package OS.rfe.by.novik.user;

import java.util.List;

public class User {
	
	public  List<System> listSystem;

	public int processesGenerated;

	public int processesToGenerate;

	public void run(int tick) {
	}

	public boolean isFinished() {
		return false;
	}

	public void addProcess(int ratio, int minICPU, int maxICPU, int minIIO, int maxIIO, int inInstructions, int maxInstructions) {
	
	}
}

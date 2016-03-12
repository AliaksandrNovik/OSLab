package OS.rfe.by.novik.scheduled;

public class ScheduledOperatrion {
	public Process processId;

	public int bytesToTransfer;

	public void ScheduledOperation(Process processed, int bytesToTransfer) {
	}

	public Process getProcessId(){
		return processId;
	}

	public int getBytesToTransfer() {
		return bytesToTransfer;
	}
}

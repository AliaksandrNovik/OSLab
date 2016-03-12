package OS.rfe.by.novik.disk;

import java.util.List;

import OS.rfe.by.novik.scheduled.ScheduledOperatrion;

public class Disk {

	enum STATE {
		SLEEP, WARMUP, SEEK, TRANSFER, COOLDOWN, IDLE
		};
		
		public STATE state;

		public int stateTime;

		public int warmupTime;

		public int seekTime;

		public int cooldownTime;

		public int transferRate;

		public int sleepTimeout;

		public int bytesToTransfer;

		public int bytesTransfered;

		public System system;

		public List<ScheduledOperatrion> scheduledOperationsList;

		public Disk(System system) {
		}

		public void requestIO(Process process, int bytesToTransfer) {
		}

		public void run() {
		}

		public int getTransferRate(){
			return transferRate;
		}
}

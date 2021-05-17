package hust.soict.globalict.aims.Aims;

public class MemoryDaemon implements Runnable {
	private long memoryUsed=0;
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while (true) {
			used = rt.totalMemory()-rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("Memory used: "+used);
				memoryUsed = used;
			}
		}
	}

}

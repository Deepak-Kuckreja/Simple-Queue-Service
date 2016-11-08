/* File: Consumer.java
 * A consumer consumes(reads) <msgCount> number of messages from
 * the MiniQ. */


public class Consumer implements Runnable {
	private MiniQ queue;
	private static int msgCount;
	private int consumerID;

	public Consumer(MiniQ q, int count, int id) {
		queue = q;
		msgCount = count;
		consumerID = id;
	}

	@Override
	public void run() {
		while (msgCount > 0) {
			try {
				Message msg = queue.get();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			msgCount--;

		}
	}

}
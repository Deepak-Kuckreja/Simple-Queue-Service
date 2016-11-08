/* File: Producer.java
 * Prototype of the producer whose job is to produce unique
 * messages of the format - P<producer id>message<message count>
 * A producer adds <msgCount> number of messages to the MiniQ */

public class Producer implements Runnable {

	private MiniQ queue;
	private static int msgCount;
	private int producerID;

	public Producer(MiniQ q, int count, int id) {
		queue = q;
		msgCount = count;
		producerID = id;
	}

	@Override
	public void run() {
		String msgStr = "";
		int msgID = 0;

		while (msgCount > 0) {

			try {
				msgStr = "P" + producerID + "message" + msgCount;
				Message msg = new Message(msgStr, msgCount);
				msgID = queue.put(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			msgCount--;
		}
	}
}

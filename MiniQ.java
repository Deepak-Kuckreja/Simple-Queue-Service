/* File: MiniQ.java
 * The underlying storage is an ArrayList which stores all the
 * messages that the producer adds and removes them when the
 * consumer consumes them.
 * synchronized, wait and notify constructs have been used to synchronize the
 * different producer and consumer threads. */

import java.util.ArrayList;
import java.util.List;

public class MiniQ {

	private List<Message> msgList;
	private int capacity;
	// private boolean busy = false;

	public MiniQ(int size) {
		capacity = size;
		msgList = new ArrayList<Message>(capacity);
	}

	/* Function Name : put
	 * Description   : Adds the message that the producer has produced.
	 * Parameters    : msg (IN) - message that needs to be added to the arraylist
	 */
	public int put(Message msg) throws InterruptedException {
		// wait if msgList is full
		while (msgList.size() == capacity) {
			synchronized (msgList) {
				System.out.println(
						"msgList is full. " + Thread.currentThread().getName() + " is waiting.");

				msgList.wait();
			}
		}

		synchronized (msgList) {
			msgList.add(msg);
			System.out.println(msg.getText() + " has been added in the MiniQ by thread "
					+ Thread.currentThread().getName());
			msgList.notifyAll();
			return msg.hashCode();
		}

	}

	/* Function Name : get
	 * Description   : removes and returns the message that the consumer has consumed(read)
	 */
	public Message get() throws InterruptedException {
		Message msg;
		// wait if msgList is empty
		while (msgList.isEmpty()) {
			synchronized (msgList) {
				System.out.println(
						"msgList is empty. " + Thread.currentThread().getName() + " is waiting.");

				msgList.wait();
			}
		}

		synchronized (msgList) {
			msgList.notifyAll();
			msg = msgList.remove(0);
			System.out.println(msg.getText() + " has been removed from the MiniQ by thread "
					+ Thread.currentThread().getName());

			return msg;
		}
	}
}

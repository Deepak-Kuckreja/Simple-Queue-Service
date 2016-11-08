/* File: QueueService.java
 * It is the driver class providing the Queue Service.
 * It creates a MiniQ and producers and consumers
 * to produce(write) and consume(read) the messages in the MiniQ. */

import java.io.BufferedReader;
import java.io.*;

public class QueueService {

	public static void main(String args[]) throws IOException {
		int size;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("!! Welcome to the Queue Service !!\n");

		System.out.println("Enter the size of MiniQ \n");
		size = Integer.parseInt(br.readLine());

		MiniQ mQ = new MiniQ(size);

		new Thread(new Producer(mQ, 3, 1), "Producer1").start();
		new Thread(new Consumer(mQ, 4, 1), "Consumer1").start();
		new Thread(new Consumer(mQ, 6, 2), "Consumer2").start();
		new Thread(new Producer(mQ, 3, 2), "Producer2").start();
	}
}

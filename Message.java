/* File: Message.java
 * Prototype of the message that is stored in the MiniQ by the
 * producer and consumed (read) by the customer. */

public class Message {
	private String text;
	private int messageID;

	public Message(String S, int id) {
		this.text = S;
		this.messageID = id;
	}

	public String getText() {
		return text;
	}

	public int getMessageID() {
		return messageID;
	}
}

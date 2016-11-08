/* File: QueueService.java
 * It is the driver class providing the Queue Service.
 * It creates a MiniQ and producers and consumers
 * to produce(write) and consume(read) the messages in the MiniQ. */
 
 /* File: Consumer.java
 * A consumer consumes(reads) <msgCount> number of messages from
 * the MiniQ. */
 
 /* File: Producer.java
 * Prototype of the producer whose job is to produce unique
 * messages of the format - P<producer id>message<message count>
 * A producer adds <msgCount> number of messages to the MiniQ */
 
 /* File: Message.java
 * Prototype of the message that is stored in the MiniQ by the
 * producer and consumed (read) by the customer. */
 
 /* File: MiniQ.java
 * The underlying storage is an ArrayList which stores all the
 * messages that the producer adds and removes them when the
 * consumer consumes them.
 * synchronized, wait and notify constructs have been used to synchronize the
 * different producer and consumer threads. */

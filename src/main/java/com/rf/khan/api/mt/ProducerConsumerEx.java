package com.rf.khan.api.mt;

import java.util.LinkedList;

/**
 * Producer and Consumer Problem code
 * 
 * @author mkhan339
 *
 */
public class ProducerConsumerEx {
	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer p = new ProducerConsumer();

		// Create producer thread
		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create consumer thread
		Thread consmer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					p.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producer.start();
		consmer.start();

		producer.join();
		consmer.join();
	}
}

/**
 * This class is created for the producer and consumer
 * 
 * @author mkhan339
 *
 */
class ProducerConsumer {

	// create a list shared producer and consumer size of list 2
	LinkedList<Integer> list = new LinkedList<Integer>();

	int capacity = 2;

	/**
	 * This method is created which is called by the producer to produce
	 * 
	 * @throws InterruptedException
	 */
	public void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			synchronized (this) {
				// producer thread while list is full;
				while (list.size() == capacity)
					wait();

				System.out.println("Producer produced- " + value);

				// to insert the job in the list
				list.add(value++);

				// notify the consumer thread that now it can start consuming
				notify();

				Thread.sleep(1000);
			}
		}
	}

	/**
	 * This method is created which is called by the consumer to consume
	 * 
	 * @throws InterruptedException
	 */
	public void consume() throws InterruptedException {

		while (true) {
			synchronized (this) {
				// consumer thread waits while list is empty
				while (list.size() == 0)
					wait();

				int retriveValue = list.removeFirst();
				System.out.println("Consumer consumed- " + retriveValue);

				// wake the producer thread
				notify();

				Thread.sleep(1000);
			}
		}
	}
}
package com.rf.khan.api.mt;

/**
 * Reader Writer Problem using Semaphores
 * 
 * Step 1: Mutex -> binary semaphore -> to ensure mutual exclusion, when read
 * count (rc) is updated.
 * 
 * No two thread modify read count at same time.
 * 
 * Step 2: WRT -> binary semaphore -> common for both read writer.
 * 
 * Step 3: Read count -> initialize with 0 not semaphore. (Track how many reader
 * are reading critical section)
 * 
 * @author mkhan339
 *
 */
public class ReaderWriterProblemSimulator {

	public static void main(String[] args) {

		final int READERS = 3;
		final int WRITER = 2;

		Database database = new Database();
		for (int i = 0; i < READERS; i++) {
			new Reader(database).start();
		}

		for (int i = 0; i < WRITER; i++) {
			new Writer(database).start();
		}
	}
}

/**
 * Database is the critical resource
 * 
 * @author mkhan339
 *
 */
class Database {
	private int readers; // no of active readers

	public Database() {
		this.readers = 0;
	}

	/**
	 * This method is created for the read to read the critical resource
	 * 
	 * @param number holds the number of reader thread
	 */
	public void read(int number) {

		synchronized (this) {
			this.readers++;
			System.out.println("Reader " + number + " starts reading.");
		}

		final int DELAY = 5000;
		try {

			Thread.sleep((int) (Math.random() * DELAY));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (this) {
			System.out.println("Reader " + number + " stops reading.");
			this.readers--;
			if (this.readers == 0) {
				this.notify();
			}
		}
	}

	/**
	 * This method is created for the write to, write on the critical resource
	 * 
	 * @param number holds the number of writer thread
	 */
	public synchronized void write(int number) {
		while (this.readers != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Writer " + number + " starts writing.");
		final int DELAY = 5000;
		try {
			Thread.sleep((int) (Math.random() * DELAY));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Writer " + number + " stops writing.");
		this.notifyAll();
	}
}

/**
 * Reader thread class
 * 
 * @author mkhan339
 *
 */
class Reader extends Thread {

	private static int readers = 0; // number of readers

	private int number;
	private Database database;

	public Reader(Database database) {
		this.database = database;
		this.number = Reader.readers++;
	}

	@Override
	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.database.read(this.number);
		}
	}
}

/**
 * Writer thread class
 * 
 * @author mkhan339
 *
 */
class Writer extends Thread {

	private static int writers = 0;

	private int number;
	private Database database;

	public Writer(Database database) {
		this.database = database;
		this.number = Writer.writers++;
	}

	@Override
	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) Math.random() * DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.database.write(this.number);
		}
	}
}

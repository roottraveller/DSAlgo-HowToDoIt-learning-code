package multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Lock Class Hierarchy:
 * 
 *                 (I) java.util.concurrent.locks.Lock
 *                          |
 *            ______________|________________
 *           |                                |
 *       (C) ReentrantLock     (C) ReentrantReadWriteLock
 *           |                                |
 *           |                                |
 *       (I) Condition                (C) ReadLock    (C) WriteLock
 *                                              |
 *                                              |
 *                                        (C) Sync.Mutex
 */

/*
 * Read Lock:
 *     - Allows multiple threads to acquire the lock simultaneously for reading.
 *     - While a thread holds a read lock, other threads can also acquire read locks, but no thread can acquire a write lock until all read locks are released.
 *     - Read locks are shared, meaning multiple threads can hold them simultaneously.
 *
 * Write Lock:
 *     - Grants exclusive access to a single thread for writing.
 *     - While a thread holds a write lock, no other thread can acquire either a read or write lock until the write lock is released.
 *     - Write locks are exclusive, meaning only one thread can hold the write lock at any given time.
 */
public class ReentrantReadWriteLockDemo {
    private static final int READERS_COUNT = 3;
    private static final int WRITERS_COUNT = 2;

    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final StringBuilder sharedData = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < READERS_COUNT; i++) {
            Thread readerThread = new Thread(new Reader(), "Reader-" + i);
            readerThread.start();
        }

        for (int i = 0; i < WRITERS_COUNT; i++) {
            Thread writerThread = new Thread(new Writer(), "Writer-" + i);
            writerThread.start();
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            readWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is reading data: " + sharedData.toString());
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            readWriteLock.writeLock().lock();
            try {
                String newData = Thread.currentThread().getName() + "'s data";
                sharedData.append(newData);
                System.out.println(Thread.currentThread().getName() + " is writing data: " + newData);
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }
    }
}

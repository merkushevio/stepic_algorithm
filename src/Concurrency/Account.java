package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private volatile int balance;
    private Lock lock;
    private AtomicInteger failCounter;

    public Account(int balance) {
        this.balance = balance;
        this.lock = new ReentrantLock();
        this.failCounter = new AtomicInteger();
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void incFailedTransferCount() {
        failCounter.incrementAndGet();
    }

    public int getFailCounter() {
        return failCounter.get();
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}

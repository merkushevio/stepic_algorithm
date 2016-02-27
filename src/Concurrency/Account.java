package Concurrency;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}

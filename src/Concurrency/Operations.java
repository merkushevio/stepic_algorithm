package Concurrency;

import java.util.concurrent.TimeUnit;

public class Operations {
    final int WAIT_SEC = 5;
    public static void main(String[] args) {

        final Account account1 = new Account(1000);
        final Account account2 = new Account(2000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(account1, account2, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            transfer(account2, account1, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InnsuficcientFundsException, InterruptedException {
        if (acc1.getBalance() < amount) {
            throw new InnsuficcientFundsException();
        }
        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        acc1.withDraw(amount);
                        acc2.deposit(amount);
                    }finally {
                        acc2.getLock().unlock();
                    }
                }
            }finally {
                acc1.getLock().unlock();
            }
        }
        else {
            //error, waiting lock
        }

    }
}

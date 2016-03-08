package Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
    private Account accFrom;
    private Account accTo;
    private int amount;
    private int WAIT_SEC = 5;

    public Transfer(Account accFrom, Account accTo, int amount) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        if (accFrom.getBalance() < amount) {
            throw new InnsuficcientFundsException();
        }
        if (accFrom.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (accTo.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        if (accFrom.getBalance() < amount) {
                            throw new InnsuficcientFundsException();
                        }
                        accFrom.withDraw(amount);
                        accTo.deposit(amount);
                        Thread.sleep((int)(Math.random()*100));
                    }  finally {
                        accTo.getLock().unlock();
                    }
                } else {
                    accTo.incFailedTransferCount();
                    return false;
                }
            }finally {
                accFrom.getLock().unlock();
            }
        }
        else {
            //error, waiting lock
            accFrom.incFailedTransferCount();
            return false;
        }
        return true;
    }
}

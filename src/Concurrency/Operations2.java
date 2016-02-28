package Concurrency;

import java.util.concurrent.*;

public class Operations2 {
    public static void main(String[] args) throws InterruptedException {
        Account accFrom = new Account(1000);
        Account accTo = new Account(300);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService service = Executors.newFixedThreadPool(3);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("Failed From: " + accFrom.getFailCounter());
                System.out.println("Failed To: " + accTo.getFailCounter());
            }
        }, 0, 1, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            service.submit(new Transfer(accFrom, accTo, (int) (Math.random() * 400)));
        }
        service.shutdown();

        CountDownLatch latch = new CountDownLatch(5);

        service.awaitTermination(20, TimeUnit.SECONDS);
    }
}

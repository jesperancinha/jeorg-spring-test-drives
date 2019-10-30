package com.steelzack.b2b2java8.concurrency;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class StampedLock1 {

    protected void runStampedLockExample1(){
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        final Map<String, String> map = new HashMap<>();
        final StampedLock lock = new StampedLock();

        final int[] globalCouter = {0};

        final Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            try {
                sleep(2000);
                map.put("foo", "bar" + (globalCouter[0]++));
                System.out.println("This is the current timestamp " + new Date().getTime() + " for task " + globalCouter[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };
        executor.submit(writeTask);
        executor.submit(writeTask);

        final Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        for (int i = 0; i < 25; i++) {
            executor.submit(readTask);
        }

        stop(executor);
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
}

package com.solvd.theater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadRunnable implements Runnable{
    private static final Logger logger = LogManager.getLogger(ThreadRunnable.class);
    private final int threadNumber;

    public ThreadRunnable (int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        logger.info("Multithreading test implementing Runnable");
        for (int i = 1; i < 6; i++) {
            logger.info(" Thread number: "+i+"/"+threadNumber);
            try {
                Thread.sleep(500);
                logger.info(" Thread number: "+i+" is going to sleep, bye");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

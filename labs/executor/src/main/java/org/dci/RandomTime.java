package org.dci;

import java.util.concurrent.Callable;

public class RandomTime implements Callable<String> {
    private int workId;

    public RandomTime(int workId) {
        this.workId = workId;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(getRandomNumber(1, 3) * 1000L);
        return  "Random Time Task " + workId + " is done!";
    }
}

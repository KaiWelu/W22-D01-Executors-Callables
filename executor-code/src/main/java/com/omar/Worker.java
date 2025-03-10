package com.omar;

public class Worker implements Runnable{
    private int workId;

    public Worker(int workId) {
        this.workId = workId;
    }


    @Override
    public void run() {
        System.out.println("Task with id: " + workId + " being executed by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

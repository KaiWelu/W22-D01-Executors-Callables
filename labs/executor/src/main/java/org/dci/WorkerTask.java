package org.dci;

public class WorkerTask implements Runnable{

    private int workId;

    public WorkerTask(int workId) {
        this.workId = workId;
    }

    @Override
    public void run() {
        System.out.println("Task with id: " + workId + " being executed by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println("Task " + workId + " done!");
        } catch(InterruptedException e) {
            throw  new RuntimeException(e);
        }
    }

}

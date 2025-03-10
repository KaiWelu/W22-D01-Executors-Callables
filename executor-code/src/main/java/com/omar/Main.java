package com.omar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        argument: number of threads in thread tool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i =0; i<7; i++){
            executorService.execute(new Worker(i+1));
        }

        executorService.shutdown();



    }
}
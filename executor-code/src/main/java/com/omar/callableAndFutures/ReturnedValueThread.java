package com.omar.callableAndFutures;

import java.util.concurrent.Callable;

public class ReturnedValueThread implements Callable<Integer> {
    @Override
    public Integer call() {
        try {
            Thread.sleep(3000);
            return 11;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

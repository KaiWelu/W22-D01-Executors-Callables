package com.omar.callableAndFutures.exercise;

import java.util.concurrent.Callable;

public class MultipleCalculator implements Callable<Integer> {
    private int num1;
    private int num2;
    private int timeout;

    public MultipleCalculator(int num1, int num2, int timeout) {
        this.num1 = num1;
        this.num2 = num2;
        this.timeout = timeout;
    }
    public MultipleCalculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(timeout);
        return num1*num2;
    }
}

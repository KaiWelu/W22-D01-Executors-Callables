package org.dci;

import java.util.concurrent.Callable;

public class SquareCalculator implements Callable<Integer> {
    private int number;


    public SquareCalculator(Integer number) {
        this.number = number;

    }

    @Override
    public Integer call() {
        System.out.println("Calculating square of " + number);
        return  number*number;
    }
}

package com.omar.callableAndFutures;

import com.omar.callableAndFutures.exercise.MultipleCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//       basicCallable();
//        invokingAll();
        invokeAny();
    }

    public static void invokingAll() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> returnedValues = Arrays.asList(
                new MultipleCalculator(2,3),
                new MultipleCalculator(4,4),
                new MultipleCalculator(10,10)
        );

        List<Future<Integer>> returnedResults =  executorService.invokeAll(returnedValues);

        for(Future<Integer> future : returnedResults){
            System.out.println(future.get());
        }

        executorService.shutdown();
    }

    public static void invokeAny() throws InterruptedException, ExecutionException{
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> returnedValues = Arrays.asList(
                new MultipleCalculator(2,3,4000),
                new MultipleCalculator(4,4,2000),
                new MultipleCalculator(10,10,3000)
        );

        Integer result =  executorService.invokeAny(returnedValues);

        System.out.println(result);


        executorService.shutdown();
    }

    public static void basicCallable(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> returnValue =  executorService.submit(new ReturnedValueThread());

        try{
            System.out.println(returnValue.get(4, TimeUnit.SECONDS));
        } catch (Exception e) {
            System.out.println("Took too long to get the value");
        }

        executorService.shutdown();

    }
}

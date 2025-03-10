package org.dci;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//      Task 1
//      new executor service
        ExecutorService exService = Executors.newFixedThreadPool(3);
//      create threads
        for(int i = 0; i < 7; i++) {
            exService.execute(new WorkerTask(i+1));
        }
//      shutdown the executor service
        exService.shutdown();

//      Task 2
        ExecutorService exServiceSquared = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> returnedValues = Arrays.asList(
                new SquareCalculator(5),
                new SquareCalculator(10),
                new SquareCalculator(3),
                new SquareCalculator(153370)
                                                              );
        List<Future<Integer>> returnedResults = exServiceSquared.invokeAll(returnedValues);
        for(Future<Integer> future : returnedResults) {
            System.out.println(future.get());
        }
        exServiceSquared.shutdown();

//        Task3
        ExecutorService executorRandom = Executors.newFixedThreadPool(2);
        List<Callable<String>> returnedRandomValues = Arrays.asList(
                new RandomTime(1),
                new RandomTime(2),
                new RandomTime(3)
                                                             );
        List<Future<String>> returnedRandom = executorRandom.invokeAll(returnedRandomValues);
        for (Future<String> future : returnedRandom) {
            System.out.println(future.get());
        }
        System.out.println("First completed result: " + executorRandom.invokeAny(returnedRandomValues));
        executorRandom.shutdown();
    }
}
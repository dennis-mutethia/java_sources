package com.dennis.threads;

import static com.dennis.utils.Logging.LOGGER;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DennisMutethia
 */
public class Slave {
    public void run() {
        LOGGER.log(Level.INFO, "Entering  run() >>>>>>>");

        List<Callable<Integer>> tasks = new ArrayList<>();

        // Create tasks for each WebScraper.getMatches call
        tasks.add(() -> this.getSum(10, 20));
        tasks.add(() -> this.getDifference(10, 20));
        tasks.add(() -> this.getProduct(10, 20));
        
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
        try {
            List<Future<Integer>> invokeAll = executorService.invokeAll(tasks);    
            for(Future<Integer> future : invokeAll){
                Integer value = future.get();
                System.out.println(value);
            }
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        } finally {
            // Ensure that the executor service is always shut down when done
            executorService.shutdown();
            LOGGER.log(Level.INFO, "<<<<<< Exiting  run()");
        }
    }
    
    private int getSum(int a, int b){
        return a + b;
    }
    
    private int getDifference(int a, int b){
        return a - b;
    }
    
    private int getProduct(int a, int b){
        return a * b;
    }
        
}

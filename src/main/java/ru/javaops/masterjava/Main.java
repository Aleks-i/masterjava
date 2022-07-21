package ru.javaops.masterjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.format("Hello MasterJava!");

//        Callable<String> task = () -> Thread.currentThread().getName();
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        List<Future<String>> futures = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            futures.add(executorService.submit(task));
//        }
//        futures.forEach(f -> {
//            try {
//                System.out.println(f.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdown();
        double singleThreadSum = 0.;
        int[] array = getInitArray(10000);
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int j : array) {
            Thread.sleep(1);
            sum += j;
        }
        System.out.println(sum);
        double duration = (System.currentTimeMillis() - start) / 1000.;
        out("Time, sec: %.3f", duration);
        singleThreadSum += duration;
    }

    public static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = 1;
        }
        return array;
    }

    private static void out(String format, double ms) {
        System.out.println(String.format(format, ms));
    }
}

package me.whiteship.java8to11.pr7_3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () ->{
          Thread.sleep(2000L);
          return "Hello";
        };
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone()); // 끝났으면 true, 안끝났으면 false

        System.out.println("Started!");

        // true: 현재 진행중인 작업 interrupt하면서 종료, false: 기다림, 기다렸다해도 일단 cancel하면
        // get으로 가져올 수 없다. 그리고 isDone()은 true가된다. 작업이 종료됐으니
        helloFuture.cancel(true);
        System.out.println(helloFuture.isDone());
        //helloFuture.get(); // 블록킹 콜, 값을 가져올 때까지 기다림, cancel하면 값 못가져온다.
        System.out.println("End");
        executorService.shutdown();

        System.out.println("=============");

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        Callable<String> the = () ->{
            Thread.sleep(2000L);
            return "The";
        };
        Callable<String> java = () ->{
            Thread.sleep(3000L);
            return "java";
        };
        Callable<String> gyuTae = () ->{
            Thread.sleep(1000L);
            return "gyuTae";
        };
        List<Future<String>> futures = executorService1.invokeAll(Arrays.asList(the, java, gyuTae));
        for (Future<String> future : futures) {
            System.out.println("future.get() = " + future.get());
        }
        String s = executorService2.invokeAny(Arrays.asList(the, java, gyuTae));
        System.out.println("s = " + s);
        executorService2.shutdown();
        executorService1.shutdown();
    }
}

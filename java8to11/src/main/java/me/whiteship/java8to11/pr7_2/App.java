package me.whiteship.java8to11.pr7_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("Thread "+ Thread.currentThread().getName());
            System.out.println("==============");
        });
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello "));
        executorService1.submit(getRunnable("gyuTae "));
        executorService1.submit(getRunnable("the "));
        executorService1.submit(getRunnable("java "));
        executorService1.submit(getRunnable("thread "));
        executorService1.shutdown();

        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        //3초 뒤에 실행시키기!
        executorService2.schedule(getRunnable("Hello"),3, TimeUnit.SECONDS);
        executorService2.shutdown();

        ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
        //shutdown 없으면 1초있다가 출력되고 2초마다 출력된다.
        executorService3.scheduleAtFixedRate(getRunnable("Hello"),1, 2, TimeUnit.SECONDS);
        executorService3.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}

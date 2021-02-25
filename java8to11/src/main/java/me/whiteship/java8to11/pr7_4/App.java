package me.whiteship.java8to11.pr7_4;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        // 기본 값을 gyuTae로 정해주면서 작업자체를 끝낸다. 명시적으로 값주기
        future.complete("gyuTae");
        System.out.println(future.get());
        System.out.println("=============");

        CompletableFuture<String> future2 = CompletableFuture.completedFuture("gyuTae");
        System.out.println(future2.get());
        System.out.println("=============");

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        // get, join을 해야 위에 행동이 발생한다. join을 하면 익셉션이 벌어져야하는 상황에서
        // uncatchedException으로 던져줘서 명시를 안해도되서 편하기도 하다.
        future3.get();
        System.out.println("=============");

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future4.get());
        System.out.println("=============");

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s)->{
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future5.get());
        System.out.println("=============");

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s)->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("s.toUpperCase() = " + s.toUpperCase());
        });
        future6.get();
        System.out.println("=============");

        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName());
        });
        future7.get();
        System.out.println("=============");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(()->{
            System.out.println(Thread.currentThread().getName());
        });
        future8.get();
        executorService.shutdown();
        System.out.println("=============");
    }
}

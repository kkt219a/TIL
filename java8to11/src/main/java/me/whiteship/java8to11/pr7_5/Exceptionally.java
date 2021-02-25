package me.whiteship.java8to11.pr7_5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exceptionally {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = true;
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwError){
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex ->{ // 에러 없으면 실행 x
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(hello.get());
    }
}

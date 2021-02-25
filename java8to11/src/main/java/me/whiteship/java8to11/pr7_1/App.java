package me.whiteship.java8to11.pr7_1;

public class App {

    //psvm sleep
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L); // 현재 쓰레드 재우고 다른 쓰레드 먼저 동작(main)
            } catch (InterruptedException e) { // 자는 동안 누군가 꺠우면 여기로 들어온다.
                e.printStackTrace();
            }
            System.out.println("Thread2: "+Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("App.main");
    }

    //psvm interrupt
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while(true) {
//                System.out.println("Thread2: " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L); // 현재 쓰레드 재우고 다른 쓰레드 먼저 동작
//                } catch (InterruptedException e) { // 자는 동안 누군가 꺠우면 여기로 들어온다.
//                    System.out.println("exit!");
//                    return;
//                }
//            }
//        });
//        thread.start();
//        System.out.println("Hello2: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();
//    }

    // psvm join
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("Hello: " + Thread.currentThread().getName());
//
//        Thread thread = new Thread(() -> {
//            System.out.println("Thread2: " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                throw new IllegalStateException(e);
//            }
//        });
//        thread.start();
//        System.out.println("Hello2: " + Thread.currentThread().getName());
//        try {
//            thread.join(); // 이 쓰레드 끝날떄까지 기다림
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(thread + " is finished");
//    }

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("Thread= " + Thread.currentThread().getName());
        }
    }
}

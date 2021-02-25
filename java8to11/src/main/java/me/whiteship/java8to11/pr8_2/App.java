package me.whiteship.java8to11.pr8_2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();
        //랜덤하게 채우기
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

        //시작시간 재고 정렬을 한다. 쓰레드 하나만 쓴다. 자바는 기본적으로 퀵소트를 쓴다.
        long start = System.nanoTime();
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        //시작시간 재고 병렬정렬을 한다. 쪼개고 합치는게 머지소트같은데, 여러 쓰레드를 이용해서
        // 분할하고 정복하는 원리같다.
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}

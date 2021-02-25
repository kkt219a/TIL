package me.whiteship.java8to11.pr8_1;

import java.util.Arrays;
import java.util.List;

@Chiken("양념")
@Chiken("마늘간장")
public class App {

    public static void main(String[] args) {

        //1번 방식, 클래스에서 치킨타입으로 바로 읽어오는 방법
        Chiken[] chickens = App.class.getAnnotationsByType(Chiken.class);
        Arrays.stream(chickens).forEach(c ->{
            System.out.println(c.value());
        });

        //2번 방식, 컨테이너 타입으로 가져오는 방법
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

}

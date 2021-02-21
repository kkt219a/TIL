package me.whiteship.java8to11.pr2_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {
    public static void main(String[] args) {
        // Greeting에서 같은 동작을 하는 hi method가 있으니 메소드 레퍼런스 사용가능
        //UnaryOperator<String> hi = (s)->"hi"+s;
        // 생성자 없어도 되나..?
        //메소드를 아직 호출한게 아니다 아직 Unary!
        UnaryOperator<String> hi = Greeting::hi;
        // 이 때 인스턴스에 메소드에 전달되서 출력
        System.out.println("hi.apply(\"ss\") = " + hi.apply("ss"));

        Greeting greeting = new Greeting();
        // Greeting에서 같은 동작을 하는 hi method가 있으니 메소드 레퍼런스 사용가능
        //UnaryOperator<String> hello = (s)->"hello"+s;
        UnaryOperator<String> hello = greeting::hello;

        // Supplier지 Greeting이 아니다. 실제 인스턴스가 만들어 지는 것이 아님.
        Supplier<Greeting> newGreeting = Greeting::new;
        // get을 하면 그 때 인스턴스를 만들며 가져옴
        Greeting greeting1 = newGreeting.get();

        //위와 레퍼런스는 같아보이지만 서로 다른 생성자를 참조한다. 위는 인자가 없는 생성자 참조!
        Function<String, Greeting> gyuTaeGreeting = Greeting::new;
        Greeting gyuTae = gyuTaeGreeting.apply("GyuTae"); // 인스턴스 생성
        System.out.println("gyuTae.getName() = " + gyuTae.getName());

        String[] names = {"gyutae", "spring", "zzang"};
        // 정렬을 Comparator 구현
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        // 람다로 줄이기 가능
        Arrays.sort(names, (o1,o2) -> 0);
        // 람다가 가능하니 메소드 레퍼런스 사용 가능
        // 문자열이 다른 문자열과 비교해서 int 값을 넘겨주는 compareToIgnoreCase는 String Class 안에 있고,
        // 자기 자신의 문자열이랑 내가 파라미터로 받은 문자열이랑 비교해서 int 값을 넘겨준다.
        // gyutae가 뒤에오는 spring을 compareToIgnoreCase의 파라미터로 넘겨서 int값을 리턴!
        // 그리고 spring이 뒤에오는 zzang을 compareToIgnoreCase의 파라미터로 넘겨서 int값을 리턴! 하며 동작
        // 즉, 이 메소드 레퍼런스는 위의 임의의 names 레퍼런스들을 거쳐가며 compareToIgnoreCase라는
        // 인스턴스 메소드를 사용하는 것이다.
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}

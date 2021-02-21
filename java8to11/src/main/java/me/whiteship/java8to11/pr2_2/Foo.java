package me.whiteship.java8to11.pr2_2;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println("plus10.apply(1) = " + plus10.apply(1)); // 11

        Function<Integer, Integer> plus10_1 = (n)-> n+10;
        System.out.println("plus10_1.apply() = " + plus10_1.apply(1)); // 11

        Function<Integer,Integer> multiply2 = (n) -> n*2;
        System.out.println("multiply2.apply(1) = " + multiply2.apply(1)); // 2

        //2를 곱하고 plus10의 함수를 사용
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println("multiply2AndPlus10.apply(2) = " + multiply2AndPlus10.apply(2)); // 14

        // plus10을 행하고 multiply2를 실행
        System.out.println(plus10_1.andThen(multiply2).apply(2)); // 24

        // 2개 타입을 받아서 String으로 반환
        BiFunction<Integer, Boolean, String> biFunction = (i,j) -> "hello bifunction!"+i+j;
        System.out.println(biFunction.apply(2,true));

        // Integer 타입을 받아서 아무값도 리턴하지 않는 함수
        Consumer<Integer> printT = (i)-> System.out.println(i);
        printT.accept(10); // 10

        // Integer 값을 단순히 가져오는 함수형 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get()); // 10

        //String을 받아서 gyuTae로 시작하는지 확인 true, false
        Predicate<String> startsWithGyuTae = (s) -> s.startsWith("gyuTae");
        Predicate<String> equalsGyuTae = (s) -> s.equals("gyuTae2");
        Predicate<String> and = startsWithGyuTae.and(equalsGyuTae);
        System.out.println("and = " + and.test("gyuTae")); // true && false = false
        Predicate<String> or = startsWithGyuTae.or(equalsGyuTae);
        System.out.println("and = " + or.test("gyuTae")); // true || false = tuue
        Predicate<String> negate = startsWithGyuTae.negate();
        System.out.println("and = " + negate.test("gyuTae")); // !true = false

        UnaryOperator<Integer> multiply3 = (i) -> i*3;
        System.out.println("multiply3.apply() = " + multiply3.apply(2)); // 6

        BinaryOperator<Integer> binaryOperator = (i,j)-> 10;
        System.out.println("binaryOperator.apply(2,3) = " + binaryOperator.apply(2, 3)); // 10


    }
}

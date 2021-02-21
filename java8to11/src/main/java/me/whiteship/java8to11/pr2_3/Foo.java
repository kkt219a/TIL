package me.whiteship.java8to11.pr2_3;


import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run(){
        int baseNumber = 10;

        //로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println("baseNumber = " + baseNumber); // 11
            }
        }

        //익명 크래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println("integer = " + baseNumber); // 파라미터 baseNumber 출력
            }
        };

        //람다
        IntConsumer printInt = (i) -> {
            System.out.println(i+baseNumber); // run과 같은 scope이라 선언 불가
        };
        printInt.accept(10);
    }
}

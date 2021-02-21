package me.whiteship.java8to11;

public class Foo {
    public static void main(String[] args) {
        //자바8 이전에 사용하던 "익명 내부 클래스 anonymous inner class"
        RunSomething runSomethingPrev = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("prev java8");
                System.out.println("Please Lambda!");
            }
        };

        //위를 람다형태로 변경했을 때, 위와 동일한 것이다. 줄여쓰는!
        RunSomething runSomethingJava8 = () -> {
            System.out.println("java 8");
            System.out.println("Hello Lambda!");
        };

        RunSomething runSomethingJava8two = () -> System.out.println("hi java8 inline!");

        runSomethingPrev.doIt();
        runSomethingJava8.doIt();
        runSomethingJava8two.doIt();

    }
}

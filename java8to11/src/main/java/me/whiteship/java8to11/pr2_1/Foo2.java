package me.whiteship.java8to11.pr2_1;

public class Foo2 {

    public static void main(String[] args) {
        int baseNumber = 10;
        RunSomething2 runSomething2 = new RunSomething2() {

            int baseNumber2 = 15;

            @Override
            public int doIt(int number) {
                // 변경 불가. 내부 클래스에서 할 수 없는 일! 문법적으로도 틀림.
                // baseNumber++;

                // 문법적으로는 가능하지만 퓨어한 함수라고 볼 수 없는 함수.
                // 자바8부터는 지원이 가능하기때문에 무조건 함수형 프로그램을 해야하는 건 아니지만
                // 문법이 혀용되는 내에서, 필요하면 함수형 프로그래밍 하는거고, 아니면 편의상
                // 아래처럼 써도 된다. 하지만 람다 익스프레션으로 줄일 순 없다.
                // baseNumber2++;

                return number+baseNumber;
            }
        };

        // 내부클래스에서 사용했기 때문에, 아래처럼 값이 변경되면 내부클래스에서 컴파일 오류가 발생한다.
        // 내부 클래스에서는 final이라고 가정을하고 쓰는 것이기때문에!
        // 따라서 위의 내부클래스에서 저렇게 사용하려면 아래 변수를 final로 지정해야한다.
        //baseNumber++;

        // 가능!
        RunSomething2 runSomething2_1 = number -> number + baseNumber;
    }
}

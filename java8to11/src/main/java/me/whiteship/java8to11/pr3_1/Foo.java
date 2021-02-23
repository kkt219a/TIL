package me.whiteship.java8to11.pr3_1;

public interface Foo {

    static void printAnything(){
        System.out.println("Foo.printAnything");
    }

    void printName();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();
}

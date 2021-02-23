package me.whiteship.java8to11.pr3_1;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("gyuTae");
        foo.printName();
        foo.printNameUpperCase();
        Foo.printAnything();
    }
}

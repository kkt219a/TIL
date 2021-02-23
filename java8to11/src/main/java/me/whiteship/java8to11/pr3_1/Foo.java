package me.whiteship.java8to11.pr3_1;

public interface Foo {
    void printName();

    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();
}

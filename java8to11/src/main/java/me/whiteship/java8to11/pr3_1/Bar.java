package me.whiteship.java8to11.pr3_1;

public interface Bar extends Foo {

    default void printNameUpperCase(){
        System.out.println("getName().toUpperCase() = " + getName().toUpperCase());
    }

}

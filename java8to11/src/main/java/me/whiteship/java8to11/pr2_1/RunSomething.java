package me.whiteship.java8to11.pr2_1;


@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName(){
        System.out.println("Gyutae");
    }

    default void printAge(){
        System.out.println("25");
    }

}

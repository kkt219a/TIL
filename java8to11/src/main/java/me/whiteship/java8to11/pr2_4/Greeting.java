package me.whiteship.java8to11.pr2_4;

public class Greeting {
    private String name;
    public Greeting(){}
    public Greeting(String name){ this.name = name; }
    public String hello(String name){ return "hello "+ name; }
    public static String hi(String name){ return "hi " + name; }
    public String getName() { return name; }
}

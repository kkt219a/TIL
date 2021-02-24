package me.whiteship.java8to11.pr6_1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("time = " + time);
        System.out.println("date = " + date);
        Thread.sleep(3000);
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds);
        after3Seconds.setTime(time);
        System.out.println("after3Seconds = " + after3Seconds);

        Calendar gyuBirthday = new GregorianCalendar(1997, Calendar.FEBRUARY,19);
        System.out.println("gyuBirthday.getTime() = " + gyuBirthday.getTime());
        gyuBirthday.add(Calendar.DAY_OF_YEAR,1);
        System.out.println("gyuBirthday.getTime() = " + gyuBirthday.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat();

    }
}

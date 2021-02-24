package me.whiteship.java8to11.pr6_2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("zonedDateTime = " + zonedDateTime);

        System.out.println("============");

        // 현재시간, 내 시스템 정보를 참고. 서버가 미국이면 미국시간으로 찍힌다.
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        //Month를 Month.JULY를 써도 된다.
        LocalDateTime birthday = LocalDateTime.of(1997, 2, 19, 0, 0, 0);
        System.out.println("birthday = " + birthday);

        //특정 존의 시간을 보고싶다. 아래 두개는 똑같이 나와야한다.
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);

        System.out.println("============");
        
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthday = LocalDate.of(2022, 2, 19);
        Period period = Period.between(today, nextYearBirthday);
        System.out.println("period.getDays() = " + period.getDays());

        Period until = today.until(nextYearBirthday);
        System.out.println("until.get(ChronoUnit.DAYS) = " + until.get(ChronoUnit.DAYS));

        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println("between.getSeconds() = " + between.getSeconds());

        System.out.println("============");

        LocalDateTime now3 = LocalDateTime.now();
        //위의 포멧을 보고 할 수 있다. 그리고 패턴을 지정할 수 있고 새로 정의할 수도 있다.
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("now.format(MMddyyyy) = " + now.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("02/19/1997", MMddyyyy);
        System.out.println("parse = " + parse);

        System.out.println("============");

        Date date = new Date();
        Instant instant1 = date.toInstant(); // date --> instant
        Date newDate = Date.from(instant1); // instant --> date

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        // gregorianCalendar --> zoneDateTime
        ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        // zoneDateTime --> gregorianCalendar
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime2);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();// timeZone --> ZoneId
        TimeZone timeZone = TimeZone.getTimeZone(zoneId); // ZoneId --> timeZone

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime plus1 = now1.plus(10, ChronoUnit.DAYS); // 바뀐건 새로 인스턴스에!


    }
}

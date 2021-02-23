package me.whiteship.java8to11.pr3_2;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("gyuTae");
        name.add("json");
        name.add("xml");
        name.add("type");
        name.add("gyutae");

        //순회, 다 출력 가정 Consumer가 인자다 + 메소드 레퍼런스까지!
        name.forEach(System.out::println);
        // 위와 같긴한데, 위가 더 간결
        for (String n : name) {
            System.out.println(n);
        }

        //iterator와 비슷한데 split, 쪼갤 수 있는 iterator라고 생각.
        Spliterator<String> spliterator = name.spliterator();
        // 보통 반으로 쪼개진다, 가능한 반으로 홀수일 땐 한 쪽이 더 많고. 위에 선언한 것도 반으로 쪼개진 나머지가!
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        //내부에 메소드, 다음게 없으면 false를 리턴하고 있으면 계속 순회하며 돈다.
        System.out.println("==========");
        while(spliterator.tryAdvance(System.out::println)); // xml, type
        System.out.println("==========");
        while(stringSpliterator.tryAdvance(System.out::println)); //gyutae, json

        //뒤에서 더 자세히
        Set<String> g = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("g"))
                .collect(Collectors.toSet());
        System.out.println("==========");
        System.out.println("g = " + g);

        //p로 시작하는 걸 빼라
        name.removeIf(s->s.startsWith("p"));
        System.out.println("==========");
        name.forEach(System.out::println);

        // 대, 소문자 구분 없이 같은지 비교하는 Comparator
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        // 역순으로 하고 다시 대소문자 구분있이 비교
        name.sort(compareToIgnoreCase.reversed().thenComparing(String::compareTo));
        System.out.println("==========");
        name.forEach(System.out::println);
        
    }

}

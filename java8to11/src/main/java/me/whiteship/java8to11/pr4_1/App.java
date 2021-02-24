package me.whiteship.java8to11.pr4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("gyuTae");
        names.add("json");
        names.add("xml");
        names.add("type");
        names.add("gyutae");

        // 여기서 데이터를 대문자로 바꾼건 또다른 스트림에 담길 뿐인거다. 결국 map 중개 오퍼레이터
        // collect 터미널 오퍼레이션때문에 출력을 하는 것을 알 수 있다. 실제 map에서 행동들을
        // 터미널 오퍼레이션이 붙음으로써 처리가 된다는 것을 알 수 있다. collect를 지우면
        // 중개오퍼레이터에서 멈춰서 map내부가 진행되지 않는다.
        List<String> collect = names.stream()
                .map((s) -> {
                    System.out.println("s = " + s);
                    return s.toUpperCase();
                }).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("=====================");
        // 출력해보면 기존은 변하지 않은걸 알 수 있다.
        names.forEach(System.out::println);
        System.out.println("=====================");
        // 기존 for문은 이렇게 쓰는데 굳이 스트림 써야하냐?
        // 병렬적으로 처리가 어렵다
        for (String name : names) {
            if(name.startsWith("g")){
                System.out.println("name.toUpperCase() = " + name.toUpperCase());
            }
        }
        System.out.println("=====================");
        // parallelStream이 병렬적으로 처리를 해준다. 그냥 stream을 사용하면 main 쓰레드에서 다 돌고
        // parallelStream을 쓰면 멀티쓰레드가 가능하다. 출력해보면 알 수 있다.
        // parallelStream을 쓴다해서 무조건 다 빨라지는 건 아니다. 느려질수도 있다.
        // 병렬이 다 좋은거면 리액티브 스트림같은게 등장한 이유가 없다.
        // 쓰레드를 만들어서 처리하면 비용이 든다. 만들고, 병렬 처리하고 수집하고, 쓰레드끼리 왔다갔다하는 스위칭 비용
        // 하지만 멀티쓰레드가 유용한 경우 데이터가 방대한 경우! 데이터 소스와 처리 내용에따라 달라질 수 있어서
        // 실제로 케이스마다 한 번씩 성능 측정을 해보고 선택해야한다.
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s+" "+Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }
}

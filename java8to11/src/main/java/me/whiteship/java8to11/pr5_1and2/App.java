package me.whiteship.java8to11.pr5_1and2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "restapi development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println("present = " + present);

        spring.ifPresent(oc -> System.out.println(oc.getTitle()));
        //있으면 꺼내온다, 단 있든 없든 create 메소드는 실행을 한다.
        OnlineClass onlineClass = spring.orElse(createNewClass());
        System.out.println("onlineClass.getTitle() = " + onlineClass.getTitle());

        OnlineClass onlineClass1 = spring.orElseGet(App::createNewClass);
        System.out.println("onlineClass1.getTitle() = " + onlineClass1.getTitle());

        //대안이 없는 경우
        OnlineClass onlineClass2 = spring.orElseThrow(IllegalStateException::new);
        System.out.println("onlineClass2.getTitle() = " + onlineClass2.getTitle());

        //optional 값 걸러내기
        Optional<OnlineClass> onlineClass3 = spring
                .filter(OnlineClass::isClosed);
        System.out.println("onlineClass3.isEmpty() = " + onlineClass3.isEmpty());

        //내부도 optional이면 한 번 더 까준다. 플랫으로! 아래는 맵으로 했을 때 같은 것.
        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);

        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProgress);
        progress1.orElse(Optional.empty());

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}

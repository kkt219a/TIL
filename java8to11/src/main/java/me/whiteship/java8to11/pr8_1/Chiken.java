package me.whiteship.java8to11.pr8_1;

import java.lang.annotation.*;

// 이 애노테이션 정보를 언제까지 유지할 것인가 - 자바5
@Retention(RetentionPolicy.RUNTIME)
// 이 애노테이션을 사용할 곳,타입 파라미터
//@Target(ElementType.TYPE_PARAMETER)
// 좀 더 자유롭게 쓰고싶다, 타입 파라미터를 포함해서 타입을 선언하는 모든곳에 이 애노테이션 사용 가능
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chiken {
    String value();
}

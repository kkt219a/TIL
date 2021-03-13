package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MVC 프레임워크 만들기 - 6
 */
public interface MyHandlerAdapter {

    //처리할 수 있는지 판단 여부
    boolean supports(Object handler);

    // 핸들러를 호출하고, 반환할 때 ModelView에 맞춰서 반환. 유연해야해서 Object
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}

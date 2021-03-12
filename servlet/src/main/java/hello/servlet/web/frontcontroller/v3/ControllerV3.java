package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * MVC 프레임워크 만들기 - 4
 */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}

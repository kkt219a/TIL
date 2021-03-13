package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * MVC 프레임워크 만들기 - 5
 */
public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);

}

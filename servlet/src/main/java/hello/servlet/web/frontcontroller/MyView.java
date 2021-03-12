package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * MVC 프레임워크 만들기 - 3
 */
public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    //모델의 데이터를 request의 attribute로 변경!
    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        //가져온 모델을 전부 풀며, request에 setAttribute로 값을 다 복사해서 넣는다.
        //model.forEach((key, value) -> request.setAttribute(key,value));
        model.forEach(request::setAttribute);
    }
}

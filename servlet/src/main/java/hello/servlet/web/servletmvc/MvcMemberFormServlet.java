package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jsp패턴 - 5
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //컨트롤러에서 뷰로 이동할 때 사용 이 경로로 이동하겠다라는 설정
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //servlet에서 jsp를 호출한다. 서버에서 내부에서 호출하는 것, 제어권을 넘기는 것
        dispatcher.forward(request, response);
    }
}

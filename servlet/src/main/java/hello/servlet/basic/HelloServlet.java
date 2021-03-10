package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 서블릿 파트 - 2
 */

// name은 아무거나, 클래스명과 비슷하게 줬다. /hello 로 오면 여기로 들어간다.
// name과, Patterns는 당연히 중복 금지!
@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //서블릿이 호출되면 service method가 호출된다
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        // 아래 둘 다 interface다. 톰캣이나 제티 등의 WAS서버들이 서블릿 표준 스펙을
        // 구현한다. 그 구현체가 아래 출력 결과다.
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // getParameter로 key를 넣으면 된다. servlet이 알아서 빼와준다!
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //response 추가! 얘에 추가하면 반환된다.
        response.setContentType("text/plain");
        // 무조건 얘로 쓰자! 옛날 시스템 아니면.
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);
    }


}

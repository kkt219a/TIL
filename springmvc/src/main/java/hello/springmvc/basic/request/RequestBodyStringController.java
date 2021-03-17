package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * 스프링 MVC 기본 기능 - 9
 */

@Slf4j
@Controller
public class RequestBodyStringController {

    // get에도 body를 넣을 수 있지만 실무에선 그렇게 안쓰지
    @PostMapping("request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        // 스트림은 바이트코드니까 어떤 인코딩으로해서 바꿀건지 항상 지정해줘야한다. 아니면
        // 디폴트, os나 자바에서 사용하는
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}",messageBody);
        response.getWriter().write("ok");
    }

    @PostMapping("request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}",messageBody);
        responseWriter.write("ok");
    }

    //HttpEntity를 상속받은 RequestEntity나, ResponseEntity를 쓸 수도 있다.
    @PostMapping("request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}",messageBody);
        return new HttpEntity<>("ok");
    }

    // 리퀘스트바디에 스트링으로 되있으면 http메시지 바디 읽어서 여기다가 바로 넣어주는 것.
    // 리스폰스바디도 물론 가능!
    @ResponseBody
    @PostMapping("request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("messageBody={}",messageBody);
        return "ok";
    }



}

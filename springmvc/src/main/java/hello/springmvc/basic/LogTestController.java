package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 스프링 MVC 기본 기능 - 2
 */
// @Controller는 String은 view반환,Rest는 그대로 문자열 반환
@Slf4j
@RestController
public class LogTestController {
    //getClass 또는 내 클래스 지정, 롬복으로 지정
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //얘는 어느 레벨이든 다 출력되니까 쓰면 안되는 것
        System.out.println("name = " + name);

        // 이렇게 사용하면 안됨. 자바가 메서드 호출하기 전에 name을 Spirng으로 치환하고 더한다.
        // 연산이 되서 만들어서 가지고 있는다. 연산이 일어나며 메모리도 사용하고 ,cpu도 사용한다.
        // 로그 레벨이 debug라도 trace가 연산과정에서 메모리와 cpu를 사용하는 것! 출력 안해도!
        //log.trace("trace log="+ name);

        // 실행 시간, info, 프로세스id, [현재실행 쓰레드], 컨트롤러 이름, 메시지
        // 레벨 설정은 application.properties, 메소드를 호출하며 파라미터만 넘겨서
        // 로직이 중지가 되는 것! 그래서 이렇게 사용해야한다.
        log.trace("trace log={}", name);

        log.debug("debug log={}", name);
        log.info("info log={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }
}

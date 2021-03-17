package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 스프링 MVC 기본 기능 - 11
 */
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello");
        return mav;
    }

    // 리스폰스바디 쓰면 뷰로 안가고 저 문자 그대로 출력이지!
    //@ResponseBody
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","hello");
        return "response/hello";
    }

    // 권장x, 불명확, 관례로 도와주는 것. 컨트롤러 경로이름과 뷰의 논리적 이름이 같으면,
    // 즉 아무것도 반환 안하면 요청온 컨트롤러 경로로 논리적 뷰 이름으로 진행된다.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data","hello");
    }
}

package site.metacoding.pagetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    // 컨트롤러 페이지 작동 테스트

    @GetMapping("/test/user/joinForm")
    public String test6() {
        return "user/joinForm";
    }

    @GetMapping("/test/user/loginForm")
    public String test7() {
        return "user/loginForm";
    }
}
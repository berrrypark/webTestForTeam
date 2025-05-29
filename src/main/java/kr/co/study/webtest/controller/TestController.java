package kr.co.study.webtest.controller;

import kr.co.study.webtest.dto.TestService;
import kr.co.study.webtest.entity.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public Test index() {
        return testService.findByFeeDvcd("MFMB002");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}

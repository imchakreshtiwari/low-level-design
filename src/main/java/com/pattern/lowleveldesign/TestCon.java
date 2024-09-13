package com.pattern.lowleveldesign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCon {

    @GetMapping("/")
    public void test() {
        System.out.println("Hello controller!!!!!!!!!!!");
    }
}

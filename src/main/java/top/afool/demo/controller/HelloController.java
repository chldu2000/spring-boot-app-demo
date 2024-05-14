package top.afool.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/name/{input}")
    public String hello(@PathVariable String input) {
        return "Hello, " + input + "!";
    }
}

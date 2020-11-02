package site.assad.springcluodnetflix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerCtl {
    
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "，this is first message";
    }
    
    @RequestMapping("/info")
    public String getInfo(@RequestParam String token) {
        return "hello world, token is " + token;
    }
    
}

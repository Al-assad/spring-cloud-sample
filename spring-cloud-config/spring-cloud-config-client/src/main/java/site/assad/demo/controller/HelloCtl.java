package site.assad.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloCtl {
    
    @Value("${assad.hello}")
    private String hello;
    
    @GetMapping("/hello")
    public String hello(){
        return hello;
    }
    
}

package site.assad.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackCtl {

    @GetMapping("/fallback")
    public String fallback(){
        return "this is fallback call!";
    }
    
}

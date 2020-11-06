package site.assad.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingCtl {
    
    
    @GetMapping("/ping")
    public String greeting(){
        return "pong";
    }
    
}

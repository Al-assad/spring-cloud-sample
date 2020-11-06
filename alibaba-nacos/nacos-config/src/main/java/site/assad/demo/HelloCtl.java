package site.assad.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloCtl {
    
    @Value("${greeting:hi}")
    private String greetingContent;
    
    @GetMapping("/greeting")
    public String greeting(){
        return greetingContent;
    }
    
}

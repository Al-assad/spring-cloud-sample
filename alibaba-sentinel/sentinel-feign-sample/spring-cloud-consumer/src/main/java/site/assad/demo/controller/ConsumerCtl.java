package site.assad.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.assad.demo.remote.HelloRemote;

@RestController
public class ConsumerCtl {
    
    @Autowired
    HelloRemote helloRemote;
    

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        String result = helloRemote.hello(name);
        return result;
    }
    
    
    
}

package site.assad.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.assad.demo.remote.HelloRemote;

/**
 * spring cloud consul - openfeign 远程调用实例
 */
@RestController
public class ConsumerCtl {
    
    @Autowired
    private HelloRemote helloRemote;
    
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }
    
    
}

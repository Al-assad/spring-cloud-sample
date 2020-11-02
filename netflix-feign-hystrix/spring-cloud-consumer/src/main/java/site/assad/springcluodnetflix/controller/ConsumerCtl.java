package site.assad.springcluodnetflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.assad.springcluodnetflix.remote.HelloRemote;

@RestController
public class ConsumerCtl {
    
    @Autowired
    HelloRemote helloRemote;
    
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }
    
}

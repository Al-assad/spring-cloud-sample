package site.assad.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerCtl {
    
    private final static transient Logger log = LoggerFactory.getLogger(ProducerCtl.class);
    
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        log.info("hello, " + name);
        throw new RuntimeException("circuit break!!!");
    }
    
}

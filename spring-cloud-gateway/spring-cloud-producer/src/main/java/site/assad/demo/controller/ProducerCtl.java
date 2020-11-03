package site.assad.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerCtl {
    
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + "，this is first message";
    }
    
    @GetMapping("/name/{name}")
    public String name(@PathVariable("name") String name){
        return "hello, " + name;
    }
    
    @GetMapping("/longtask")
    public String longhandle() throws InterruptedException {
        Thread.sleep(1000 * 60);
        return "done!";
    }
    
    
}

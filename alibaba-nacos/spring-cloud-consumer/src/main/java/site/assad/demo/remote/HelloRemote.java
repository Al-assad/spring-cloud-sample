package site.assad.demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-producer")
public interface HelloRemote {
    
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
    
}

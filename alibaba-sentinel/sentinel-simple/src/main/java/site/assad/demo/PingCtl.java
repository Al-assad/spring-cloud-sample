package site.assad.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PingCtl {
    
    @Autowired
    TestService testService;
    
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
    
    /**
     * 演示自定义资源点
     */
    @GetMapping("/ping2")
    public String ping2() {
        return testService.ping2();
    }
    
    /**
     * 演示限流阻塞处理
     */
    @GetMapping("/ping3")
    public String ping3(){
        return testService.ping3();
    }
    
    /**
     * 演示熔断降级处理
     */
    @GetMapping("/ping4")
    public String ping4(){
        return testService.ping4();
    }
    
    
    
}

package site.assad.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 自定义资源点
 */
@Slf4j
@Service
public class TestService {
    
    /**
     * 演示自定义资源点
     */
    @SentinelResource(value = "service-ping2")
    public String ping2(){
        return "pong";
    }
    
    /**
     * 演示限流阻塞处理
     */
    @SentinelResource(value = "service-ping3",  blockHandler="blockHandler")
    public String ping3(){
        return "pong";
    }
    
    public void blockHandler(String str, BlockException ex){
        log.error("handle block: {} , {}", str, ex);
    }
    
    /**
     * 演示熔断降级处理
     */
    @SentinelResource(value = "service-ping4",  fallback="fallbackHandler")
    public String ping4(){
        log.info("ping4：pong");
        throw new RuntimeException("circuit break!!!");
    }
    
    public static void fallbackHandler(String str){
        log.error("handle fallback: {}", str);
    }
    
}

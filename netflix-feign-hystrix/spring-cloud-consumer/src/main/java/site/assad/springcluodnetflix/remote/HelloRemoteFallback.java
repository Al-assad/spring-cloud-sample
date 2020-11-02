package site.assad.springcluodnetflix.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloRobustRemote Feign 客户端 Hystrix fallback
 *
 * @author yulinying
 * @since 2020/11/2
 */
@Component
public class HelloRemoteFallback implements HelloRemote {
    
    @Override
    public String hello(String name) {
        return "hello " + name + ", this message send failed ";
    }
    
}

package site.assad.demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign 远程调用客户端
 *
 * @author yulinying
 * @since 2020/11/2
 */
@FeignClient(name = "service-producer")
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}

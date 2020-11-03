package site.assad.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * consul 服务查看示例
 */
@RestController
public class ServerCallCtl {
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    /**
     * 获取指定命名服务所有可用服务
     */
    @GetMapping("/service")
    public Object listServices(){
        return discoveryClient.getInstances("service-producer");
    }
    
    /**
     * 轮询指定命名服务
     */
    @GetMapping("/chooseService")
    public Object chooseService(){
        return loadBalancerClient.choose("service-producer");
    }
    
}

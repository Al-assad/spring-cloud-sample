package site.assad.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import site.assad.demo.remote.HelloRemote;

@RestController
public class ConsumerCtl {
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    HelloRemote helloRemote;
    
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    /**
     * 通过 RestTemplate 调用
     */
    @GetMapping("/hello/v1/{name}")
    public String helloV1(@PathVariable("name") String name) {
        String result = restTemplate.getForObject("http://spring-cloud-producer/hello?name=" + name, String.class);
        return result;
    }
    
    /**
     * 通过 FeignClient 调用
     */
    @GetMapping("/hello/v2/{name}")
    public String helloV2(@PathVariable("name") String name) {
        String result = helloRemote.hello(name);
        return result;
    }
    
    /**
     * 通过 WebClient 调用
     */
    @GetMapping("/hello/v3/{name}")
    public Mono<String> helloV3(@PathVariable("name") String name) {
        Mono<String> result = webClientBuilder.build()
                .get()
                .uri("http://spring-cloud-producer/hello?name=" + name)
                .retrieve()
                .bodyToMono(String.class);
        return result;
    }
    
    
}

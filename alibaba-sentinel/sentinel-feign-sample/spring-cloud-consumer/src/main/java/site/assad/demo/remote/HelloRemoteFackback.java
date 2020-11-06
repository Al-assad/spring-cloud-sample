package site.assad.demo.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteFackback implements HelloRemote{
    
    @Override
    public String hello(String name) {
        return "fallback, name=" + name;
    }
    
}

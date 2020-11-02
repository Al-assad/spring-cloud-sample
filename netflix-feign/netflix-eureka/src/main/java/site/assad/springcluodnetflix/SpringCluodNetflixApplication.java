package site.assad.springcluodnetflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCluodNetflixApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringCluodNetflixApplication.class, args);
    }
    
}

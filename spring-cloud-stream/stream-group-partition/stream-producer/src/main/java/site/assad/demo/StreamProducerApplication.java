package site.assad.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(SampleTopic.class)
@SpringBootApplication
public class StreamProducerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StreamProducerApplication.class, args);
    }
    
}

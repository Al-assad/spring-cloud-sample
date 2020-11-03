package site.assad.demo.topic;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息主题通道
 */
public interface SampleTopic {
    
    String OUTPUT = "sample-topic";
    String INPUT = "sample-topic";
    
    /**
     * 发布消息通道
     */
    @Output(OUTPUT)
    MessageChannel output();
    
    /**
     * 订阅消息通道
     */
    @Input(INPUT)
    SubscribableChannel input();
    
    
}

package site.assad.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息主题通道
 */
public interface SampleTopic {
    
    String NAME = "test-topic";
    
    /**
     * 发布消息通道
     */
    @Output(NAME)
    MessageChannel output();
    
    /**
     * 订阅消息通道
     */
    @Input(NAME)
    SubscribableChannel input();
    
    
}

package site.assad.demo.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import site.assad.demo.topic.SampleTopic;

/**
 * 消息消费者
 *
 * @author yulinying
 * @since 2020/11/3
 */
@Slf4j
@Component
public class SinkReceiver {
    
    /**
     * 消费逻辑
     */
    @StreamListener(SampleTopic.INPUT)
    public void receive(String payload) {
        log.info("Received: " + payload);
    }
    
}

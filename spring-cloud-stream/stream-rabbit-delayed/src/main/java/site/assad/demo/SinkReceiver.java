package site.assad.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import site.assad.demo.SampleTopic;

/**
 * 消息消费者
 *
 * @author yulinying
 * @since 2020/11/3
 */
@Slf4j
@EnableBinding(SampleTopic.class)
public class SinkReceiver {
    
    @StreamListener(value = SampleTopic.INPUT)
    public void receiveV1(String payload) {
        log.info("Received: " + payload);
    }
    
}

package site.assad.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 消息消费者
 *
 * @author yulinying
 * @since 2020/11/3
 */

@EnableBinding(SampleTopic.class)
public class SinkReceiver {
    
    private final static Logger log = LoggerFactory.getLogger(SinkReceiver.class);
    /**
     * 消费逻辑
     */
    @StreamListener(SampleTopic.NAME)
    public void receive(String payload) {
        log.info("Received: " + payload);
    }
    
}

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
    
    /**
     * 分流 version 1.0
     */
    @StreamListener(value = SampleTopic.INPUT, condition = "headers['version']=='1.0'")
    public void receiveV1(String payload, @Header("version") String version) {
        log.info("Received: " + payload + ", version: " + version);
    }
    
    /**
     * 分流 version 2.0
     */
    @StreamListener(value = SampleTopic.INPUT, condition = "headers['version']=='2.0'")
    public void receiveV2(String payload, @Header("version") String version) {
        log.info("Received: " + payload + ", version: " + version);
    }
    
}

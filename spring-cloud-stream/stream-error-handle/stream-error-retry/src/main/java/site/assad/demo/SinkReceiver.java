package site.assad.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author yulinying
 * @since 2020/11/3
 */
@Slf4j
@Component
public class SinkReceiver {
    
    @StreamListener(value = SampleTopic.INPUT)
    public void receiveV1(String payload) {
        log.info("Received: " + payload );
        throw new RuntimeException("message consumer failed!");
    }
    
    /**
     * 自定义错误处理降级逻辑
     * inputChannel：<destination>.<group>.errors
     */
    @ServiceActivator(inputChannel = "sample-topic.stream-error-handle-sample.errors")
    public void errorHandle(Message<?> message){
        log.info("message consumer failed callback action! errorMsg: " + message.getPayload());
    }
    
}

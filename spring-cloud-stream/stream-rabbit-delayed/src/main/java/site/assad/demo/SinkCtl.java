package site.assad.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.assad.demo.SampleTopic;

@Slf4j
@RestController
public class SinkCtl {

    @Autowired
    private SampleTopic sampleTopic;
    
    /**
     * 发送消息
     */
    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String message){
        // 发送消息，设置 5s 延迟后消费
        sampleTopic.output().send(MessageBuilder.withPayload(message).setHeader("x-delay", 5000).build());
        log.info("Send：" + message);
        return "Send：" + message;
    }
    
    
}

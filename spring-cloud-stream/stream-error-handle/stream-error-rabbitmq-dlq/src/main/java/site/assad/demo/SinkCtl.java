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
        sampleTopic.output().send(MessageBuilder.withPayload(message).build());
        log.info("Send：" + message);
        return "Send：" + message;
    }
    
    
}

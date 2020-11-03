package site.assad.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return "Send：" + message;
    }
    
    
}

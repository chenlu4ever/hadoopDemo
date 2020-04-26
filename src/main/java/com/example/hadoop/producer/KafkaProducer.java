package com.example.hadoop.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("kafka")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send")
    public void testSentMsg(int patition){
        Map msg = new HashMap();
        msg.put("name","张三");
        msg.put("tel","18903004059");
        msg.put("addr","长江下去发的发生的");
        msg.put("desc","kdf绝代风华撒地方的释放的时间副书记佛吉的说法");
        kafkaTemplate.send("test0425",patition,"key_testpring","1111111111111111111111111111111111111111");
    }
}

package com.example.hadoop.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final String TOPIC_TEST="test";

    @KafkaListener(topics = {"test0425"})
    public void testListener(ConsumerRecord record){
        System.out.println("-----------------------------");
        System.out.println("topic:" + record.topic());
        System.out.println("patition:" + record.partition());
        System.out.println("offset:" + record.offset());
        System.out.println("key:" + record.key());
        System.out.println("value:" + record.value());
        System.out.println("-----------------------------");
    }
}

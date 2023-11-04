package com.paigu.interview.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@RocketMQMessageListener(consumerGroup = "springProduceDemo", topic = "alarmChange")
@Service
public class AlarmChangeRocketMQListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        //System.out.println(message);
        log.info(message);
    }
}

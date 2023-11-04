package com.paigu.interview.controller;

import com.paigu.interview.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RocketMQController {
    private final RocketMQTemplate rocketMQTemplate;

    @GetMapping("/rocketmq/produce")
    public CommonResult produceMsg(String msg){
        GenericMessage<String> genericMessage = new GenericMessage<>(msg);
        rocketMQTemplate.send("alarmChange",genericMessage);
        return CommonResult.ok("发送消息成功");
    }
}

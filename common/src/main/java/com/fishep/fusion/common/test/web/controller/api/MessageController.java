package com.fishep.fusion.common.test.web.controller.api;

import cn.hutool.core.util.IdUtil;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.test.message.TestMessage;
import com.fishep.fusion.common.test.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/common/message")
public class MessageController {

    @Autowired
    MessageProvider messageProvider;

    @GetMapping("/rocketmq/send")
    public Result rocketmqSend()
    {
        TestMessage message = new TestMessage();
        message.setUuid(IdUtil.simpleUUID());
        message.setMessage("hello rocketmq!");

//        boolean flag = messageProvider.send("hello rocketmq!");
        boolean flag = messageProvider.send(message);

        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage("rocketmq send message");
        result.setData(flag);

        return result;
    }
}

package com.yang.workstream.service.impl;

import com.yang.workstream.service.ImesageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Service
public class MessageProvider implements ImesageProvider {

    @Autowired
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(message).build());
        return message;
    }
}

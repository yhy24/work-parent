package com.yang.workstream.controller;

import com.yang.workstream.service.ImesageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendController {
    @Autowired
    private ImesageProvider imesageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        return imesageProvider.send();
    }
}

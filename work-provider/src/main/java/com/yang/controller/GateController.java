package com.yang.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateController {

    @RequestMapping("/get")
    public String get() {

        return "测试一下";
    }
    @RequestMapping("/lb/{id}")
    public String lb(@PathVariable("id") String id) {
        return id;
    }


}

package com.seata.work.controller;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * @author yhy
 */
public class ControllerSeata {

    @GlobalTransactional
    public String getGlobal() {
        System.out.println("反向补偿");
        return "反向补偿机制";
    }
}

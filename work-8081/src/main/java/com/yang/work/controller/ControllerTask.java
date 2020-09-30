package com.yang.work.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ControllerTask {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            Date date = new Date(1599544006466L);//2020-09-08 13:46:46:466
            Date date2 = new Date(1599544006524L);//2020-09-08 13:46:46:524
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            System.out.println(simpleDateFormat.format(date2));

        } catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }
}

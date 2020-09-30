package com.yang.work.util.face.impl;

import com.yang.work.util.face.CallbackListener;
import com.yang.work.util.face.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallbackServiceImpl implements CallbackService {
    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()){
                            try {
                                entry.getValue().changed(getChanged(entry.getKey()));
                            } catch (Throwable t) {
                                listeners.remove(entry.getKey());
                            }
                        }
                        Thread.sleep(5000); // 定时触发变更通知
                    } catch (Throwable t) { // 防御容错
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // 发送变更通知
    }

    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        CallbackServiceImpl service = new CallbackServiceImpl();
        System.out.println("********start***********");
        Thread.sleep(5000);
        service.addListener("123", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("12412414");
            }
        });
        Thread.sleep(10000);
        System.out.println("********end***********");
    }
}

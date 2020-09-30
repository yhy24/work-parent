package com.yang.work.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TaskUtil {


    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

       /* for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    System.out.println("*******等等****");
                    cyclicBarrier.await();
                    System.out.println("--------ok--------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }*/
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            }).start();
        }
    }
}

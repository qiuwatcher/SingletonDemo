package com.jw.client;

import com.jw.Singleton.*;

import java.util.concurrent.CountDownLatch;

/**
 * 测试五种单例模式在多线程环境下的效率；CountDownLatch
 */
public class Client03 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++) {
                    Object obj = SingletonDemo01.getInstance();
//                    Object obj = SingletonDemo02.getInstance();
//                    Object obj = SingletonDemo03.getInstance();
//                    Object obj = SingletonDemo04.getInstance();
//                    Object obj = SingletonDemo05.INSTANCE;

                }
                countDownLatch.countDown();
            }
        }).start();

        try {
            countDownLatch.await(); //main线程阻塞，直到计数器变为0，才会继续往下执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("总耗时："+(end-start));

    }

}

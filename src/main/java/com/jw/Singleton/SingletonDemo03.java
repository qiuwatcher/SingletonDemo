package com.jw.Singleton;

/**
 *
 * 双重检测锁式（由于JVM底层内部模型原因，偶尔会出问题，故不建议使用）
 */
public class SingletonDemo03 {
    private static SingletonDemo03 instance = null;

    private SingletonDemo03(){
    }

    public static SingletonDemo03 getInstance(){
        if (instance == null) {
            SingletonDemo03 singletonDemo03;
            synchronized (SingletonDemo03.class) {
                singletonDemo03 = instance;
                if (singletonDemo03 == null) {
                    synchronized (SingletonDemo03.class) {
                        if (singletonDemo03 == null) {
                            singletonDemo03 = new SingletonDemo03();
                        }
                    }
                    instance = singletonDemo03;
                }
            }
        }
        return instance;
    }
}

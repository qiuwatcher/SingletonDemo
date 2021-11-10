package com.jw.Singleton;

/**
 * 饿汉式（线程安全，调用效率高。不能延时加载）
 * 懒汉式（线程安全，调用效率不高。可以延时加载）
 *
 * 双重检测锁式（由于JVM底层内部模型原因，偶尔会出问题，故不建议使用）
 *静态内部类式（线程安全，调用效率高。可以延时加载）
 *枚举单例（线程安全，调用效率高。不能延时加载）
 */
public class SingletonDemo02 {
    private static SingletonDemo02 instance;

    private SingletonDemo02(){
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo02 getInstance(){
        if (instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}

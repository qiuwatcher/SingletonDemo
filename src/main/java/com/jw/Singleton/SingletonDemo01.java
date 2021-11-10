package com.jw.Singleton;

/**
 * 饿汉式（线程安全，调用效率高。不能延时加载）
 * 懒汉式（线程安全，调用效率不高。可以延时加载）
 *
 * 双重检测锁式（由于JVM底层内部模型原因，偶尔会出问题，故不建议使用）
 *静态内部类式（线程安全，调用效率高。可以延时加载）
 *枚举单例（线程安全，调用效率高。不能延时加载）
 */
public class SingletonDemo01 {
    //类初始化时，立即加载这个对象
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01(){
    }

    //方法未同步，调用效率高
    public static SingletonDemo01 getInstance(){
        return instance;
    }
}

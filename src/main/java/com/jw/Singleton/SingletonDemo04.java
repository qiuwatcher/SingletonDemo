package com.jw.Singleton;

/**
 *静态内部类式（线程安全，调用效率高。可以延时加载）
 */
public class SingletonDemo04 {
    //静态内部类
    private static class SingletonClassInstance{
       private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    private SingletonDemo04(){
    }

    public static SingletonDemo04 getInstance(){
        return SingletonClassInstance.instance;
    }
}

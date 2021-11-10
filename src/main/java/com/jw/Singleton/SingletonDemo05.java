package com.jw.Singleton;

/**
 *枚举单例（线程安全，调用效率高。不能延时加载）
 */
public enum SingletonDemo05 {
    //这个枚举元素，本身就是单例对象！
    INSTANCE;

    //添加相关操作
    public  void singletonOperation(){

    }
}

package com.jw.Singleton;

/**
 * 测试懒汉式单例模式 如何防止反射和反序列化漏洞
 */
public class SingletonDemo06 {
    private static SingletonDemo06 instance;

    private SingletonDemo06(){
        //添加以下代码可防止反射用构造器方法生成新对象
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    //反序列化时，如果定义了readResolve()，则直接返回此方法指定的instance对象。而不需要单独创建新的对象！
    private Object readResolve() {
        return instance;
    }


    //方法同步，调用效率低
    public static synchronized SingletonDemo06 getInstance(){
        if (instance==null){
            instance = new SingletonDemo06();
        }
        return instance;
    }
}

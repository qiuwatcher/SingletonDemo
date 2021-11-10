package com.jw.client;

import com.jw.Singleton.SingletonDemo04;
import com.jw.Singleton.SingletonDemo05;
import com.jw.Singleton.SingletonDemo06;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射和反序列化破解单例
 */
public class Client02 {

    public static void main(String[] args) {
        SingletonDemo06 s1 = SingletonDemo06.getInstance();
        SingletonDemo06 s2 = SingletonDemo06.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        //反射破解 调用私有构造器
        try {
            Class<SingletonDemo06> singletonDemo06Class = (Class<SingletonDemo06>) Class.forName("com.jw.Singleton");
            Constructor<SingletonDemo06> constructor = singletonDemo06Class.getDeclaredConstructor(null);

            SingletonDemo06 s3 = constructor.newInstance();

            System.out.println(s3);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void test(){
        //通过反序列化的方式构造多个对象
        try {
            SingletonDemo06 s1 = SingletonDemo06.getInstance();
            FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(s1);
            fileOutputStream.close();
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("acb.txt"));
            SingletonDemo06 s2 = (SingletonDemo06) inputStream.readObject();

            System.out.println(s2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

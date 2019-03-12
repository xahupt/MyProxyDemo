package com.percy.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @author percy
 * @create 2019-03-11  下午7:51
 * @descreption:
 **/
public class TestDemo {
    public static void main(String[] args) {
        subjectInterface subjectInterface= new subjectClass();
        MyInvokeHandle myInvokeHandle = new MyInvokeHandle(subjectInterface);
        System.out.println(subjectInterface.getClass().getClassLoader().getParent().toString());
        if (subjectInterface.getClass().getClassLoader().getParent().getParent() == null) {
            System.out.println("null");
        }
//        System.out.println(subjectInterface.getClass().getClassLoader().getParent().getParent().toString());
        System.out.println(subjectInterface.getClass().getClassLoader().toString());
        subjectInterface proxy = (subjectInterface) Proxy.newProxyInstance(subjectInterface.getClass().getClassLoader(),
                new Class[]{subjectInterface.class},myInvokeHandle);
//        subjectInterface proxy1 = (subjectInterface) Proxy.newProxyInstance(subjectInterface.getClass().getClassLoader(),subjectInterface.getClass().getInterfaces(),myInvokeHandle);
        subjectInterface p=proxy.SubjectMethod();
        System.out.println(Proxy.getInvocationHandler(p).toString());
        System.out.println(Proxy.isProxyClass(p.getClass()));
        System.out.println(Proxy.getProxyClass(subjectInterface.getClass().getClassLoader(),
                subjectInterface.getClass().getInterfaces()).toString());

        //生成代理的字节码文件
        byte[] bytes=ProxyGenerator.generateProxyClass("test",subjectInterface.getClass().getInterfaces());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.class");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
//        proxy.Method2();
//        proxy1.SubjectMethod();
        /**
         * 静态代理实现
         */
        System.out.println("Static Proxy---------------");
        StaticProxy staticProxy = new StaticProxy(subjectInterface);
        staticProxy.SubjectMethod();
        staticProxy.Method2();
    }
}

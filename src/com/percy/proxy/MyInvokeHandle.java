package com.percy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author percy
 * @create 2019-03-11  下午7:49
 * @descreption:
 **/
public class MyInvokeHandle implements InvocationHandler {
    private Object o;
    public MyInvokeHandle(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Subject Running Before");
        System.out.println("invoke里的o："+o.getClass().getName());
        System.out.println("------------------");
        System.out.println(method.toString());
        System.out.println("------------------");
        Object invoke = method.invoke(this.o,objects);
        System.out.println("MyInvokeHandle里的o："+this.o.toString());

        System.out.println("Subject Running After");
        System.out.println("invoke:"+invoke!=null?"null":invoke.toString());
        return o;
    }
}

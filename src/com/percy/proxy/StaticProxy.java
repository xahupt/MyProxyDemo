package com.percy.proxy;

/**
 * @author percy
 * @create 2019-03-12  下午11:02
 * @descreption:
 **/
public class StaticProxy implements subjectInterface {
    private subjectInterface subjectInterface;

    public StaticProxy(com.percy.proxy.subjectInterface subjectInterface) {
        this.subjectInterface = subjectInterface;
    }

    @Override
    public subjectInterface SubjectMethod() {
        System.out.println("before subjectClass SubjectMethod Running");
        subjectInterface.SubjectMethod();
        return null;
    }

    @Override
    public void Method2() {
        System.out.println("before subjectClass Method2 Running");
        subjectInterface.Method2();
    }
}

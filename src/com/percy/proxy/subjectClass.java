package com.percy.proxy;

/**
 * @author percy
 * @create 2019-03-11  下午7:47
 * @descreption:
 **/
public class subjectClass implements subjectInterface{
    public subjectInterface SubjectMethod(){
        System.out.println("Subject Class‘s Method is Running");
        return null;
    }

    @Override
    public void Method2() {
        System.out.println("Say Hello");
    }
}

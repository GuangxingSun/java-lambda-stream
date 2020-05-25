package com.guangxing.lambdastream.demo;

/**
 * @program java-lambda-stream
 * @description: 使用Lambda带参数案例
 * @author: Guangxing
 * @create: 2020/05/21 13:41
 */
public class LambdaDemo {
    interface Hello{
        public String sayHello(String name);
    }
    public void saySomthing(String name,Hello hello){
        System.out.println(hello.sayHello(name));
    }
    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.saySomthing("小明",name->name+" say hello!");
    }
}

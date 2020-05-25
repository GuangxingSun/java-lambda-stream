package com.guangxing.lambdastream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program java-lambda-stream
 * 使用Stream处理数据
 * @description:
 * @author: Guangxing
 * @create: 2020/05/21 14:09
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("kobe", "james", "curry", "cyyt");
        List<String> collect = list.stream()
                .filter(s -> s.startsWith("c"))
                //.map(String::toUpperCase)
                .map(String->String.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);

        StreamDemo streamDemo = new StreamDemo();
        streamDemo.test();
    }
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

        //静态方法语法	ClassName::methodName
        list.forEach(StreamDemo::print);
        int limit = 10;
        Runnable r = () -> {
            for (int i = 0; i < limit; i++) {
                System.out.println(i);
            }
        };
        new Thread(r).start();
    }

    public static void print(String ...content){


        int limit = 10;
        Runnable r = () -> {
            for (int i = 0; i < limit; i++) {
                System.out.println(i);
            }
        };
        new Thread(r).start();


        System.out.println(content);
    }


    int tmp1 = 1; //包围类的成员变量
    static int tmp2 = 2; //包围类的静态成员变量
    public void testCapture() {
        int tmp3 = 3; //没有声明为final，但是effectively final的本地变量
        final int tmp4 = 4; //声明为final的本地变量
        int tmp5 = 5; //普通本地变量
        Function<Integer, Integer> f1 = i -> i + tmp1;
        Function<Integer, Integer> f2 = i -> i + tmp2;
        Function<Integer, Integer> f3 = i -> i + tmp3;
        Function<Integer, Integer> f4 = i -> i + tmp4;
        Function<Integer, Integer> f5 = i -> {
         //   tmp5  += i; // 编译错！对tmp5赋值导致它不是effectively final的
          //  return tmp5;
            return i;
        };
        tmp5 = 9; // 编译错！对tmp5赋值导致它不是effectively final的
    }

    public interface MyInterf {
        String m1();
        default String m2() {
            return "Hello default method!";
        }
   }
}

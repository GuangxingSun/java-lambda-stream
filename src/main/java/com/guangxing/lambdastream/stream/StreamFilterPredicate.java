package com.guangxing.lambdastream.stream;

import com.guangxing.lambdastream.UserSex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program java-lambda-stream
 * @description:
 * @author: Guangxing
 * @create: 2020/05/22 09:47
 */
public class StreamFilterPredicate {
    //UserSex userSex = new UserSex();
    public static void main(String[] args) {
        User user1 = new User(1, "小明", 13, UserSex.F);
        User user2 = new User(2, "小黄", 16, UserSex.M);
        User user3 = new User(3, "小刘", 23, UserSex.F);
        User user4 = new User(4, "小杨", 32, UserSex.M);
        User user5 = new User(5, "小于", 23, UserSex.F);
        User user6 = new User(6, "小张", 24, UserSex.F);

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6);
        //第一种方法实现
//        List<User> collect = userList.stream()
//                .filter(user -> user.getAge() > 20 && user.getSex().equals(UserSex.F))
//                .collect(Collectors.toList());
        List<User> collect = userList.stream()
                .filter(User.ageGreaterThan20.and(User.userSexIsF))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}

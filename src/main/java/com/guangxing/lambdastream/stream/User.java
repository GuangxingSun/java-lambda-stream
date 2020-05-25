package com.guangxing.lambdastream.stream;

import com.guangxing.lambdastream.UserSex;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @program java-lambda-stream
 * @description: 用户实体类
 * @author: Guangxing
 * @create: 2020/05/22 09:36
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private UserSex sex;

    public static Predicate<User> ageGreaterThan20 = user -> user.getAge()>20;
    public static Predicate<User> userSexIsF = user -> user.getSex().equals(UserSex.F);
}


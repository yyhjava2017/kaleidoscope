package com.juc.pool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        User user1 = new User("tom",12,"beijing");
        User user2 = new User("fom",14,"beijing");
        User user3 = new User("hom",16,"beijing");
        User user4 = new User("yom",18,"beijing");
        User user5 = new User("aom",22,"beijing");
        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5);
        Stream<User> stream = userList.stream();
        Stream<User> userStream = stream
                .filter(u -> {return u.getAge()>15;})
                .map(u->{
                    String tname = u.getName();
                    String s = tname.toUpperCase();
                    u.setName(s);
                    return u;
                }).limit(1);
        userStream.forEach(System.out::println);
    }
}



@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name;
    private int age;
    private String address;
}

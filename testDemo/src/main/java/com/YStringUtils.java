package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class YStringUtils {

    public static boolean isSuccess(String target){
        Predicate<String> stringPredicate = x -> x.equals("Success");
        return stringPredicate.test(target);
    }

    /**
     * 遍历list集合
     */
    public static void testList(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        Stream<String> stringStream = list.stream().filter(x -> x == "A");
        stringStream.forEach(x-> System.out.println(x));
        //list.forEach(x-> System.out.println(x));
    }
}

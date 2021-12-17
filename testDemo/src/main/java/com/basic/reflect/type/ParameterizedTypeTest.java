package com.basic.reflect.type;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTypeTest {


    public static void main(String[] args) throws NoSuchFieldException {

    }


}
class Animal<T>{
    private List<T> list = new ArrayList<>();
}

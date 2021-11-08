package com.reflect.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParameterizedTypeTest {


    public static void main(String[] args) throws NoSuchFieldException {

    }


}
class Animal<T>{
    private List<T> list = new ArrayList<>();
}

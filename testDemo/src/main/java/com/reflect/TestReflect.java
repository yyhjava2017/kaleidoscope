package com.reflect;

import com.Employee;
import com.TestUtil;

public class TestReflect {
    public static void main(String[] args) throws Exception {
        Employee employee = TestUtil.getNewInstance(Employee.class);
        employee.setAge(11);
        System.out.println(employee.getAge());

        TestUtil.getGenericType(Employee.class,String.class);
    }
}

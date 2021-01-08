package com;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private Long number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Employee(String name, int age, Long number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return this.age-o.getAge();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }
}

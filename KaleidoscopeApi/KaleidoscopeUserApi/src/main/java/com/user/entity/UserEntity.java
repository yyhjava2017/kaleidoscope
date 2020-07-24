package com.user.entity;

/**
 * @zz yyh
 * @time 2020-07
 */
public class UserEntity {
    private int id;
    private String name;
    private int age;

    public UserEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}

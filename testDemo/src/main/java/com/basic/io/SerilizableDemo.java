package com.basic.io;


import com.pojo.Employee;

import java.io.*;

public class SerilizableDemo {

    public static void main(String[] args) throws Exception {
        SerilizableDemo.writeObjToFile("d:/hellotest.txt");
        SerilizableDemo.readObjectFmFile("d:/hellotest.txt");
    }
    public static void writeObjToFile(String url) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(url);
            oos = new ObjectOutputStream(fos);
            Employee e = new Employee("hello");
            oos.writeObject(e);
            oos.flush();
        }catch (Exception e){
            oos.close();
            fos.close();
        }

    }

    public static void readObjectFmFile(String url) throws Exception {
        FileInputStream fis = new FileInputStream(url);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee o = (Employee) ois.readObject();
        System.out.println(o);
        System.out.println(o.getName());
    }
}

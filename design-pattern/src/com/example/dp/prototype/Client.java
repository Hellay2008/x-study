package com.example.dp.prototype;

import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        test1();

        test2();
    }

    static void test1() throws CloneNotSupportedException{
        Department dept = new Department();
        User user =  new User();
        user.setUserName("test-user-name");
        user.setPassword("!@SDFS@@333");
        user.setDepartment(dept);
        System.out.println(user); //com.example.dp.prototype.User@1b6d3586
        System.out.println(user.getDepartment()); //com.example.dp.prototype.Department@4554617c
        System.out.println("-----clone-----");
        User user1 = (User) user.clone();
        System.out.println(user1); //com.example.dp.prototype.User@74a14482
        System.out.println(user1.getDepartment()); //com.example.dp.prototype.Department@4554617c
    }

    static void test2() throws IOException {
        System.out.println("-------------");
        Department dept = new Department();
        User user =  new User();
        user.setUserName("test-user-name");
        user.setPassword("!@SDFS@@333");
        user.setDepartment(dept);
        System.out.println(user); //com.example.dp.prototype.User@1540e19d
        System.out.println(user.getDepartment()); //com.example.dp.prototype.Department@677327b6
        System.out.println("---------deep copy---------");
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(user);
            oos.flush();

            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            User user1 = (User)ois.readObject();

            System.out.println(user1); //com.example.dp.prototype.User@5b480cf9
            System.out.println(user1.getDepartment()); //com.example.dp.prototype.Department@6f496d9f

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (baos != null){
                try {
                    baos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (bais != null){
                try {
                    bais.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}

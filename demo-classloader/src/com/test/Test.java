package com.test;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        // printClasspath();
//        printClassloader();
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\x-study\\out\\production\\test\\");


        /**
         * 加载外部class文件
         * package com.test.test1;
         *
         * public class Test {
         *     public String sayHello(String name){
         *         return "hello1 " + name;
         *     }
         * }
         */
        Class<?> c = diskClassLoader.loadClass("com.test.test1.Test");
        System.out.println(c.getName());
        try {
            Object obj = c.newInstance();
            Method method = c.getDeclaredMethod("sayHello", String.class);
            //通过反射调用Test类的say方法
            Object result = method.invoke(obj,  "will");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void printClassloader(){
        System.out.println("ClassLoader.getSystemClassLoader()=" + ClassLoader.getSystemClassLoader());
        System.out.println("Test.class.getClassLoader()=" + Test.class.getClassLoader());
        System.out.println("int.class.getClassLoader()=" + String.class.getClassLoader());
        System.out.println("Test.class.getClassLoader().getParent()=" + Test.class.getClassLoader().getParent());
        System.out.println("Test.class.getClassLoader().getParent().getParent()=" + Test.class.getClassLoader().getParent().getParent());
    }

    private static void printClasspath(){
        System.out.println("--------------boot-classpath");
        println(System.getProperty("sun.boot.class.path"));

        System.out.println("--------------ext-classpath");
        println(System.getProperty("java.ext.dirs"));

        System.out.println("--------------app-classpath");
        println(System.getProperty("java.class.path"));
    }

    private static void println(String string){
        for(String str : string.split(";")){
            System.out.println("-"+str);
        }
    }
}

package com.example.dp.state;

public class Client {
    public static void main(String[] args) {
        //环境设置环境类
        Context context = new Context();
        //设置A状态
        context.setState(StateEnums.get("A").getState());
        String result = context.handle("will");
        System.out.println(result);
        //环境设置B状态
        context.setState(StateEnums.get("B").getState());
        result = context.handle("will");
        System.out.println(result);

        System.out.println("-------------------");

        context.setState(StateEnums.A.getState());
        result = context.handle("will");
        System.out.println(result);
        context.setState(StateEnums.B.getState());
        result = context.handle("will");
        System.out.println(result);
    }
}

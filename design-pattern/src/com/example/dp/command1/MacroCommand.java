package com.example.dp.command1;

public interface MacroCommand extends Command{
    /**
     * 宏命令集的管理方法
     * 可以添加一个成员命令
     * @param command
     */
    void add(Command command);
    /**
     * 宏命令集的管理方法
     * 可以移除一个成员命令
     * @param command
     */
    void remove(Command command);
}

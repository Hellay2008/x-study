package com.example.dp.facade;

public class Computer {
    private CPU cpu = new CPU();
    private RAM ram = new RAM();
    private DISK disk = new DISK();

    public void startup(){
        System.out.println("computer startup");
        disk.startup();
        ram.startup();
        cpu.startup();
        System.out.println("computer started");
    }

    public void shutdown(){
        System.out.println("computer shutdown");
        disk.shutdown();
        ram.shutdown();
        cpu.shutdown();
        System.out.println("computer shutdown complete");
    }
}

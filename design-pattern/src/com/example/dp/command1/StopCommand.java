package com.example.dp.command1;

public class StopCommand implements Command {

    private AudioPlayer audio;

    public StopCommand(AudioPlayer audio) {
        this.audio = audio;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        audio.stop();
    }

}
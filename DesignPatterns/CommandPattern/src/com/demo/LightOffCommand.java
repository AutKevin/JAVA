package com.demo;

/**
 * 关灯命令
 */
public class LightOffCommand implements Command{
    private Receiver receiver;

    public LightOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.turnOFF();
    }
}

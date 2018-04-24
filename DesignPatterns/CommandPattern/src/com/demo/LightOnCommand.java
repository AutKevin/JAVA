package com.demo;

/**
 * 开灯命令
 */
public class LightOnCommand implements Command{
    private Receiver receiver;

    public LightOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.turnON();
    }
}

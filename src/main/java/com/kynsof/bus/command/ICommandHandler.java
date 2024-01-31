package com.kynsof.bus.command;

public interface ICommandHandler<T extends ICommand> {
    void handle(T command);
}

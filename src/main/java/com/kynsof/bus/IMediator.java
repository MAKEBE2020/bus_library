package com.kynsof.bus;

import com.kynsof.bus.command.ICommand;
import com.kynsof.bus.command.ICommandMessage;
import com.kynsof.bus.query.IQuery;
import com.kynsof.bus.query.IResponse;

public interface IMediator {
    <M extends ICommandMessage> M send(ICommand command);

    <R extends IResponse> R send(IQuery query);
}

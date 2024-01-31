package com.kynsof.bus;
import com.kynsof.bus.command.ICommand;
import com.kynsof.bus.command.ICommandMessage;
import com.kynsof.bus.command.InMemoryCommandBus;
import com.kynsof.bus.query.IQuery;
import com.kynsof.bus.query.IResponse;
import com.kynsof.bus.query.InMemoryQueryBus;
import org.springframework.stereotype.Component;

@Component
public class MediatorImpl implements IMediator {

    private final InMemoryCommandBus commandBus;

    private final InMemoryQueryBus queryBus;

    public MediatorImpl(InMemoryCommandBus commandBus, InMemoryQueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @Override
    public <M extends ICommandMessage> M send(ICommand command) {
        commandBus.dispatch(command);
        return (M) command.getMessage();
    }

    @Override
    public <R extends IResponse> R send(IQuery query) {
        return (R) queryBus.ask(query);
    }

}

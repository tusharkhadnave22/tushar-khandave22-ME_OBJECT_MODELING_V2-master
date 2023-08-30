package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IUser;

public class CreateUserCommand implements ICommand{
    private final IUser userService;
    public CreateUserCommand(IUser userService){
        this.userService=userService;
    }
    @Override
    public void execute(List<String> tokens) {
        userService.createUser(tokens.get(1));
    }
   
    
}

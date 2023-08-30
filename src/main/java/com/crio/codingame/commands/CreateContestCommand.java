package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.QuestionNotFoundException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        // Contest obj=new Contest();
        // User obj2=new User();
        // if(tokens.get(3)==null || tokens.get(3)!=){
        //     throw new
        // }
        if(tokens.size()==5)
        {
        System.out.print(contestService.create(tokens.get(0), Level.valueOf(tokens.get(2)) , tokens.get(3), Integer.valueOf(tokens.get(4))));
        return;
        }
       // if(tokens.get(3)==null)
       try{
        System.out.print(contestService.create(tokens.get(0), Level.valueOf(tokens.get(2)) , tokens.get(3),null));
       }
       catch(UserNotFoundException e){
         System.out.println("Contest Creator for given name: creator not found!");
       }
       catch(QuestionNotFoundException e){
        System.out.println("Request cannot be processed as enough number of questions can not found. Please try again later!");
       }
        
        
        // if(tokens.get(3)==null)
        // System.out.print(contestService.create(tokens.get(0), Level.valueOf(tokens.get(2)) , tokens.get(3),null));


        
    
    }
    
}

package com.crio.jukebox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.codingame.appConfig.ApplicationConfig;
import com.crio.codingame.commands.CommandInvoker;
import com.crio.jukebox.exceptions.NoSuchCommandException;
import com.crio.jukebox.exceptions.NoSuchDataException;
import com.crio.jukebox.repositories.Data.DataLoader;


public class App 
{
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        String expectedSequence = "INPUT_FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining("$"));
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
   
	}
    public static void run(List<String> commandLineArgs) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        DataLoader dataLoader = applicationConfig.getDataLoader();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader reader;
        String inputFile = commandLineArgs.get(0).split("=")[1];
        
        commandLineArgs.remove(0);
        
       for(String arg: commandLineArgs){
                        String[] splits = arg.split("=");
                        try {
                            dataLoader.executeData(splits[0], splits[1]); //we have one method to load here
                        } catch (NoSuchDataException e) {
                            e.printStackTrace();
                        }
                  }
        
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | NoSuchCommandException e) {
            e.printStackTrace();
        }
    }
}


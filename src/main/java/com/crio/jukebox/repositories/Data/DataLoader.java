package com.crio.jukebox.repositories.Data;

import com.crio.jukebox.exceptions.NoSuchDataException;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {
    private static final Map<String, IData> dataMap = new HashMap<>();

    // Register the data into the HashMap
    public void register(String dataName, IData data){
        dataMap.put(dataName,data);
    }

    // Get the registered Data
    private IData get(String dataName){
        return dataMap.get(dataName);
    }

    // Execute the registered Data
    public void executeData(String dataName, String dataPath ) throws NoSuchDataException {
        IData data = get(dataName);
        if(data == null){
            // Handle Exception
            throw new NoSuchDataException();
        }
        data.loadData(dataPath,",");
    }
}





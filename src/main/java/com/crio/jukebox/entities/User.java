package com.crio.jukebox.entities;



public class User{

  
    private Song song;
    private String name;
    private String id;
    
    public User(String name,String id){
        this.name=name;
        this.id=id;
    }

    
    public Song getSong() {
        return song;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

 
    

}

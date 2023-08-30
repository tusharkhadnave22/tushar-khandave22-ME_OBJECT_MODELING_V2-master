package com.crio.jukebox.entities;


public class Artist   {
   
    private final String name;
    private Album album;

   
 

    public Artist(String name){
      
        this.name=name;
    }
    // public Artist(Album album, Song song){
        
    //     this.album=album;
    //     this.song=song;
    // }
    
    public String getName(){
        return name;
    }

    public Album getAlbum(){
        return album;
    }
}


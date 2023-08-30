package com.crio.jukebox.entities;


public class Album {
   
    private  String name;
    private  Song song;
    private  Artist artist;
    
    public Album(String name) {
       
        this.name=name;
    }

    public Song getSong() {
        return song;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getName(){
        return name;
    }
}

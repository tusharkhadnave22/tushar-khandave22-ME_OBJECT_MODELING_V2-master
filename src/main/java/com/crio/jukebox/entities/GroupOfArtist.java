package com.crio.jukebox.entities;

import java.util.Arrays;
import java.util.List;

public class GroupOfArtist {
    private String artists;
    
    public GroupOfArtist(String artists){
        this.artists=artists;
    }

    public List<String> getGroupOfArtist(){
        String[] artist_Individual=artists.split("#");
        return Arrays.asList(artist_Individual);
    }

   
}

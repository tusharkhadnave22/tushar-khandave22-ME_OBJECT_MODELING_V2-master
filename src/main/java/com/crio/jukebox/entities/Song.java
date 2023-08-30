package com.crio.jukebox.entities;

import java.util.List;

public class Song{
    private String songName;
    private String genere;
    private Album album;
    private Artist artist;
    private GroupOfArtist groupOfArtist;
    private String index;
   


    public Song(String index,String songName, String genere, Album album, Artist artist, GroupOfArtist groupOfArtist){
        this.index=index;
        this.songName=songName;
        this.genere=genere;
        this.album=album;
        this.artist=artist;
        this.groupOfArtist=groupOfArtist;
    }

   
    public String getIndex() {
        return index;
    }


    public String getSongName() {
        return songName;
    }


    public String getGenere() {
        return genere;
    }


    public String  getAlbum() {
        return album.getName();
    }


    public String getArtist() {
        return artist.getName();
    }


    public List<String> getGroupOfArtist() {
        return groupOfArtist.getGroupOfArtist();
    }
}

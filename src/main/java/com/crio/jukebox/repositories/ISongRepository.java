package com.crio.jukebox.repositories;

import java.util.List;
import com.crio.jukebox.entities.Song;


public interface ISongRepository{
    Song getSongById(String id);
    void saveSong(Song song);
    void updateSong(Song song);
    List<Song> getAllSongs();
    void LoadSong(String Path);
    
    
}
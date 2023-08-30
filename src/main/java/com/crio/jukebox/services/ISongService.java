package com.crio.jukebox.services;

public interface ISongService {
    void playSongNext(String user_ID);
    void PlaySongPrevious(String user_ID);
    void PlayPreferredSong(String user_ID,String Song_id);
    void loadSong(String path);
}

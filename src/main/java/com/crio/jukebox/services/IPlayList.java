package com.crio.jukebox.services;



public interface IPlayList {
    void createPlayList(String id_User, String playListName, String songs);
    void deletePlayList(String userId,String playListId);
    void addSongs(String id_User, String playListName, String songs);
    void DeleteSong(String id_User, String playListName, String songs);
    void playPlayList(String user_id,String playList_id);
}

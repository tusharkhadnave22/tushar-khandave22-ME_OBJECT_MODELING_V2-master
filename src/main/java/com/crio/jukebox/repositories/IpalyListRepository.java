package com.crio.jukebox.repositories;

import java.util.List;

public interface IpalyListRepository {
    List<String> getPlayList(String playListId);
    void createPlayList(String id_user, String playListName ,String song);
    void deletePlayList(String id_user,String id_playList);
    void addSongToPlayList(String id_user, String playListName ,String song);
    void removeSongToPlayList(String id_user, String playListName ,String song);
    void playPlayList(String user_id, String playlist_id);
    String[] activePlayListAndSong(String user_id);
    void setNewActiveSong(String userid,String playListid,String songNumbe);
}

package com.crio.jukebox.services;


import com.crio.jukebox.repositories.IpalyListRepository;

public class PlayListService implements IPlayList {
    IpalyListRepository ipalyListRepository;
    public PlayListService (IpalyListRepository playListRepository){
       this.ipalyListRepository=playListRepository;
    }

    @Override
    public void createPlayList(String id_User, String playListName,String songs) {
        ipalyListRepository.createPlayList(id_User, playListName, songs);
    }

   

    @Override
    public void deletePlayList(String userId, String playListId) {
       ipalyListRepository.deletePlayList( userId, playListId);
    }

    @Override
    public void addSongs(String id_User, String playListName, String songs) {
      ipalyListRepository.addSongToPlayList(id_User, playListName, songs);
        
    }

    @Override
    public void DeleteSong(String id_User, String playListName, String songs) {
        ipalyListRepository.removeSongToPlayList(id_User, playListName, songs);
    }

    @Override
    public void playPlayList(String user_id, String playList_id) {
       ipalyListRepository.playPlayList(user_id, playList_id);
        
    }
    
}

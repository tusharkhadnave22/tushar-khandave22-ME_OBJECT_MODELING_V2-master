package com.crio.jukebox.repositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.Song;


public class playListRepository implements IpalyListRepository {
    Map<String, String> playListMap;//user id ,playlist id
    Map<String, List<String>> playList; //playlist ID , SONG LIST
    private int PlayListid=1;

    Map<String, String[]> currentSong;//user id and map of(playlist and songnumber)
    Map<String,String>PlaylistAndSong; //map of plaulist and current song
  
    private String[]activeplaylistandsong;
    public playListRepository(){
        playListMap=new HashMap<>();
        playList=new HashMap<>();
        currentSong=new HashMap<>();
        PlaylistAndSong=new HashMap<>();
        activeplaylistandsong=new String[2];
    }


    ISongRepository songRepository;
    public playListRepository(ISongRepository songRepository){
        this.songRepository=songRepository;
    }


    @Override
    public void createPlayList(String id_User, String playListName, String songs) {
       playListMap.put(id_User,Integer.toString(PlayListid));
       List<String> songList=Arrays.asList(songs.split(" "));
       playList.put(Integer.toString(PlayListid),songList);
       System.out.print("PlayList ID - "+Integer.toString(PlayListid));
    }

    @Override
    public void deletePlayList(String id_user, String id_playList) {
        
        playListMap.remove(id_user);
        playList.remove(id_playList);
        System.out.println("Delete Successful");
    }

    @Override
    public void addSongToPlayList(String id_user, String id_playList, String song) {
           List<String> songListToBeModifed = playList.get(id_playList);
           songListToBeModifed.addAll(Arrays.asList(song.split(" "))); //i did not thaught about the duplicated here
           playList.put(id_playList,songListToBeModifed);
           System.out.println("PlayList ID -"+id_playList);
           System.out.println("PlayList Name - "+playListMap.get(id_playList));
           System.out.println("Song IDs - "+playList.get(id_playList));
           
    }

    @Override
    
    public void removeSongToPlayList(String id_user, String id_playList, String song) {
        List<String> songListToBeModifed = playList.get(id_playList);
        songListToBeModifed.removeAll(Arrays.asList(song.split(" "))); //i did not thaught about the duplicated here
           playList.put(id_playList,songListToBeModifed);
          
           System.out.println("PlayList ID -"+id_playList);
           System.out.println("PlayList Name - "+playListMap.get(id_playList));
           System.out.println("Song IDs - "+playList.get(id_playList));
    }

    @Override
    public void playPlayList(String user_id, String playlist_id) {
      String songNumber=playList.get(playlist_id).get(0);
      Song song=songRepository.getSongById(songNumber);
      System.out.println("Current Song Playing");
      System.out.println("Song - "+song.getSongName());
      System.out.println("Album - "+song.getAlbum());
      System.out.println("Artist - "+song.getGroupOfArtist());
      PlaylistAndSong.put(playlist_id,songNumber);
     // currentSong.put(user_id,PlaylistAndSong);
     activeplaylistandsong[0]=playlist_id;
     activeplaylistandsong[1]=songNumber;
    }

//It is returning active playlist and song 
    @Override
    public String[] activePlayListAndSong(String user_id) {
        return currentSong.get(user_id);
    }


    @Override
    public void setNewActiveSong(String userid,String playListid,String songNumber) {
        
        activeplaylistandsong[0]=playListid;
        activeplaylistandsong[1]=songNumber;
        currentSong.put(userid,activeplaylistandsong);
    }


    @Override
    public List<String> getPlayList(String playListId) {
        return playList.get(playListId);
    }
    
}

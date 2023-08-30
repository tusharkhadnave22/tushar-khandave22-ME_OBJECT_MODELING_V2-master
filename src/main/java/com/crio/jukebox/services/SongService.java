package com.crio.jukebox.services;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IpalyListRepository;

public class SongService implements ISongService {
    private final ISongRepository songRepository;
    private final IpalyListRepository playListRepository;
     public SongService(ISongRepository songRepository,IpalyListRepository playListRepository){
        this.songRepository=songRepository;
        this.playListRepository=playListRepository;
     }

   @Override
   public void loadSong(String path) {
       songRepository.LoadSong(path);
   }

   @Override
   public void playSongNext(String user_ID) {
      //find active playlist
      //find the playlist's list of song
      //take the index of the particular song and manipulate that index
      //set current playlist at the ending
      //give output
      String []activePlayListSongAndNumber=playListRepository.activePlayListAndSong(user_ID);//current playList and songnumber
      String Playlistid=activePlayListSongAndNumber[0];
      List<String> ans =playListRepository.getPlayList(Playlistid);
      int oldIndex=ans.indexOf(activePlayListSongAndNumber[1]);
      int newIndex=oldIndex+1;
      Song song=songRepository.getSongById(ans.get(newIndex));//playlist id song id
      System.out.println("Current Song Playing");
      System.out.println("Song - "+song.getSongName());
      System.out.println("Album - "+song.getAlbum());
      System.out.println("Artist - "+song.getGroupOfArtist());
   }

   @Override
   public void PlaySongPrevious(String user_ID) {
      String []activePlayListSongAndNumber=playListRepository.activePlayListAndSong(user_ID);//current playList and songnumber
      String Playlistid=activePlayListSongAndNumber[0];
      List<String> ans =playListRepository.getPlayList(Playlistid);
      int oldIndex=ans.indexOf(activePlayListSongAndNumber[1]);
      int newIndex=oldIndex-1;
      Song song=songRepository.getSongById(ans.get(newIndex));//playlist id song id
      System.out.println("Current Song Playing");
      System.out.println("Song - "+song.getSongName());
      System.out.println("Album - "+song.getAlbum());
      System.out.println("Artist - "+song.getGroupOfArtist());
      
   }

   @Override
   public void PlayPreferredSong(String user_ID,String songId) {
      String []activePlayListSongAndNumber=playListRepository.activePlayListAndSong(user_ID);//current playList and songnumber
      String Playlistid=activePlayListSongAndNumber[0];
      List<String> ans =playListRepository.getPlayList(Playlistid);
      int oldIndex=ans.indexOf(activePlayListSongAndNumber[1]);
      //int newIndex=oldIndex-1;
      Song song=songRepository.getSongById(ans.get(oldIndex));//playlist id song id
      System.out.println("Current Song Playing");
      System.out.println("Song - "+song.getSongName());
      System.out.println("Album - "+song.getAlbum());
      System.out.println("Artist - "+song.getGroupOfArtist());
      
   }
}





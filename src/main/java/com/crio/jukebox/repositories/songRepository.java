package com.crio.jukebox.repositories;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.Data.IData;
import com.crio.jukebox.repositories.Data.SongData;

public class songRepository implements ISongRepository {
    private static Map<String,Song> songMap;
    IData songData;
    public songRepository(){
      songMap=new HashMap();
    }
    public songRepository(IData songData){
       this.songData=songData;
    }

    @Override
    public List<Song> getAllSongs() 
    {
        return null;
    }

    @Override
    public Song getSongById(String id) {
      
      return songMap.get(id);
    }

   

    @Override
    public void saveSong(Song song) {

      songMap.put(song.getIndex(),song);
      
    }

    @Override
    public void LoadSong(String Path) {
      songData.loadData(Path, ",");
      
    }

    @Override
    public void updateSong(Song song) {
      // TODO Auto-generated method stub
      
    }
   

  

    
    
    
}

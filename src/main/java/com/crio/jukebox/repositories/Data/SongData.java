package com.crio.jukebox.repositories.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Album;
import com.crio.jukebox.entities.Artist;
import com.crio.jukebox.entities.GroupOfArtist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;


public class SongData implements IData
{

    private final ISongRepository isongRepository;

    public SongData(ISongRepository iSongRepository)
    {
           this.isongRepository=iSongRepository;
    }
    @Override
    public void loadData(String dataPath, String delimiter) 
    {
        BufferedReader reader;
       
            try {
                reader = new BufferedReader(new FileReader(dataPath));
                String line = reader.readLine();
                while (line != null)
                 {
                    List<String> tokens = Arrays.asList(line.split(delimiter));
                    addSong(tokens.get(0),tokens.get(1),tokens.get(2),new Album(tokens.get(3)),new Artist(tokens.get(4)),new GroupOfArtist(tokens.get(5)));
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
           
    
    }
    private void addSong(String index,String songName, String genere, Album album, Artist artist, GroupOfArtist groupOfArtist)
    {
        this.isongRepository.saveSong(new Song( index, songName,  genere,  album,  artist,  groupOfArtist));
    }


    }
    


package com.crio.jukebox.entities;

import java.util.List;

public class PlayList  {
    private final User user;
    private List<Song> song;

    public PlayList(User user, List<Song> song){
      this.user=user;
      this.song=song;
    }

    public User getUser() {
      return user;
    }

    public List<Song> getSong() {
      return song;
    }
    
}

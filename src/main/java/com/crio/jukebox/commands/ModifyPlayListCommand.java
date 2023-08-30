package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayList;

public class ModifyPlayListCommand implements ICommand{
    IPlayList playListService;
    public ModifyPlayListCommand(IPlayList playList){
        this.playListService=playList;
    }
    @Override
    public void execute(List<String> tokens) {
          if(tokens.get(1)=="ADD-SONGS"){
            playListService.addSongs(tokens.get(2), tokens.get(3), tokens.get(4));
          }
          else{
            playListService.DeleteSong(tokens.get(2), tokens.get(3), tokens.get(4));
          }
    }
    
}

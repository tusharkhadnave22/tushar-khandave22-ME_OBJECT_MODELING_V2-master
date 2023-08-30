package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.ISongService;

public class PlaySongCommand implements ICommand {
    ISongService iSongService;
    public PlaySongCommand(ISongService iSongService){
        this.iSongService=iSongService;
    }
    @Override
    public void execute(List<String> tokens) {
       if(tokens.get(2)=="BACK"){
          iSongService.playSongNext(tokens.get(1));
       }
       else if(tokens.get(2)=="NEXT"){
         iSongService.PlaySongPrevious(tokens.get(1));
       }
        iSongService.PlayPreferredSong(tokens.get(1), tokens.get(2));
    }
    
}

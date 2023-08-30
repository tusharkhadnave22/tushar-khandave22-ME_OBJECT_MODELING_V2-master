package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayList;
import com.crio.jukebox.services.ISongService;

public class PlayPlayListCommand implements ICommand {
    IPlayList playListService;
    ISongService songService;
    public PlayPlayListCommand(IPlayList playList, ISongService songService){
        this.playListService=playList;
        this.songService=songService;
    }
    @Override
    public void execute(List<String> tokens) {
       playListService.playPlayList(tokens.get(1), tokens.get(2));
    }
    
}

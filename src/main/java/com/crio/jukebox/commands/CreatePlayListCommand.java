package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayList;

public class CreatePlayListCommand implements ICommand {
    IPlayList playListService;
    public CreatePlayListCommand(IPlayList playList){
        this.playListService=playList;
    }
    @Override
    public void execute(List<String> tokens) {
       playListService.createPlayList(tokens.get(1), tokens.get(2), tokens.get(3));
        
    }
    
}

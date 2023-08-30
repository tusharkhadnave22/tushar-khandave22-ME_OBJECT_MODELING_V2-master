package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlayList;

public class DeletePlayListCommand implements ICommand{
    IPlayList playListRepository;
    public DeletePlayListCommand(IPlayList playlist){
        this.playListRepository=playlist;
    }
    @Override
    public void execute(List<String> tokens) {
        playListRepository.deletePlayList(tokens.get(0),tokens.get(1));
    }
    
}

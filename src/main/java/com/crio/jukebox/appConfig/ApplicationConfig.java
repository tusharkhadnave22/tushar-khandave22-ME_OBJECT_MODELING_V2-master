package com.crio.jukebox.appConfig;


import com.crio.jukebox.*;
import com.crio.jukebox.commands.*;
import com.crio.jukebox.repositories.*;
import com.crio.jukebox.repositories.Data.DataLoader;
import com.crio.jukebox.services.IPlayList;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUser;
import com.crio.jukebox.services.PlayListService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.UserService;


public class ApplicationConfig {
    
private final ISongRepository isongRepository = new songRepository();
private final IpalyListRepository ipalyListRepository=new playListRepository();
private final IUserRepository  IUserRepository=new UserRepository();


private final ISongService songService=new SongService(isongRepository,ipalyListRepository);
private final IUser userService=new UserService(IUserRepository);
private final IPlayList playListService=new PlayListService(ipalyListRepository);

private final ICommand createplayListCommand= new CreatePlayListCommand(playListService);
private final ICommand CreateUserCommand=new CreateUserCommand(userService);
private final ICommand deleteplaylistCommand=new DeletePlayListCommand(playListService);
private final ICommand loadDataCommand=new LoadDataCommand(songService);
private final ICommand modifyplaylistCommand=new ModifyPlayListCommand(playListService);
private final ICommand playplaylistCommand=new PlayPlayListCommand(playListService,songService);
private final ICommand playsongCommand=new PlaySongCommand(songService);

private final CommandInvoker commandInvoker = new CommandInvoker();


public CommandInvoker getCommandInvoker(){
  commandInvoker.register("LOAD-DATA",loadDataCommand);
  commandInvoker.register("CREATE-USER",CreateUserCommand);
  commandInvoker.register("CREATE-PLAYLIST",createplayListCommand);
  commandInvoker.register("DELETE-PLAYLIST",deleteplaylistCommand);
  commandInvoker.register("PLAY-PLAYLIST",playplaylistCommand);
  commandInvoker.register("MODIFY-PLAYLIST",modifyplaylistCommand);
  commandInvoker.register("PLAY-SONG",playsongCommand);
  return commandInvoker;
}


}

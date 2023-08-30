package com.crio.jukebox.services;

import com.crio.jukebox.repositories.IUserRepository;

public class UserService implements IUser {
    IUserRepository userRepository;
    public UserService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }
    
    @Override
    public void createUser(String name) {
      
         userRepository.createUser(name);
        System.out.print("Playlist IDn"+userRepository.getUserId(name).getName());
    }
    
}

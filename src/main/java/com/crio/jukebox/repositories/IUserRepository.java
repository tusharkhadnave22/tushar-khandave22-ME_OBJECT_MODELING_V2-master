package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.User;

public interface IUserRepository {
    void createUser(String name);
    User getUserId(String name);
}

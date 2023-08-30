package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import com.crio.jukebox.entities.User;


public class UserRepository implements IUserRepository {
    Map<String, User> userCatalog=new HashMap<>();
    private int count=0;
    @Override
    public void createUser(String name) {
      String s=Integer.toString(count+1);
      userCatalog.put(name,new User(name,s));
    }
    @Override
    public User getUserId(String name) {
      // TODO Auto-generated method stub
      return userCatalog.get(name);
    }
    
    
    
    
}
 
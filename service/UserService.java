package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.User;
import com.shravani.cuseprotect.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public static User retrieveUser(String id) {

        return null;
    }

    //to update the existing users
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add); //iterate over all users in database
        return users;
    }

    //to add new users
    public void addUsers(User users){
        userRepo.save(users);
    }
}

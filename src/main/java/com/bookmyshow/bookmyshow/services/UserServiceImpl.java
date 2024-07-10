package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserInterface {



    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public User login(String name, String email, String password) {
        return null;
    }
}

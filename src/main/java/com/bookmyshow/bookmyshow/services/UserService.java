package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.User;

public interface UserService {

    User login(String email, String password);

    User signUp(String name, String email, String password);
}

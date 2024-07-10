package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.User;

public interface UserInterface {

    User login(String email, String password);

    User login(String name, String email, String password);
}

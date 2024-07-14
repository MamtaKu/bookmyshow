package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.exceptions.InvalidCredentialException;
import com.bookmyshow.bookmyshow.exceptions.UserAlreadyExistsException;
import com.bookmyshow.bookmyshow.exceptions.UserNotFoundException;
import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User with given email does not exist: " + email );
        }

        User user = userOptional.get();
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            throw new InvalidCredentialException("Credentials are invalid");
        }

    }

    @Override
    public User signUp(String name, String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException("User with given email is already present.");
        }
        User newuser = new User();
        newuser.setPassword(password);
        newuser.setName(name);
        newuser.setEmail(email);

        return userRepository.save(newuser);

    }


}

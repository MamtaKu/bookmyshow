package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.UserLoginRequestDTO;
import com.bookmyshow.bookmyshow.dtos.UserLoginResponseDTO;
import com.bookmyshow.bookmyshow.dtos.UserSignUpRequestDTO;
import com.bookmyshow.bookmyshow.dtos.UserSignUpResponseDTO;
import com.bookmyshow.bookmyshow.models.BookingStatus;
import com.bookmyshow.bookmyshow.models.User;
import com.bookmyshow.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO){

        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();

        try{
            User user = userService.signUp(userSignUpRequestDTO.getName()
                    , userSignUpRequestDTO.getEmail()
                    , userSignUpRequestDTO.getPassword());

            responseDTO.setId(user.getId());
            responseDTO.setName(user.getName());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setTickets(user.getTickets());
            return responseDTO;

        }catch (Exception e){
            System.out.println("Something went wrong");
            return responseDTO;
        }
    }

    @RequestMapping(path ="/login")
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO){
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();

        User userlogin =
                userService.login(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());

        userLoginResponseDTO.setBookingStatus(BookingStatus.CONFIRMED);
        return userLoginResponseDTO;


    }

}

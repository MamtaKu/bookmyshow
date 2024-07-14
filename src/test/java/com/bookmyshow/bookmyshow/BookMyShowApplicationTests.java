package com.bookmyshow.bookmyshow;

import com.bookmyshow.bookmyshow.controllers.UserController;
import com.bookmyshow.bookmyshow.dtos.UserLoginRequestDTO;
import com.bookmyshow.bookmyshow.dtos.UserLoginResponseDTO;
import com.bookmyshow.bookmyshow.dtos.UserSignUpRequestDTO;
import com.bookmyshow.bookmyshow.dtos.UserSignUpResponseDTO;
import com.bookmyshow.bookmyshow.models.BookingStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSignUp(){

        UserSignUpRequestDTO requestDTO = new UserSignUpRequestDTO();
        requestDTO.setName("Mamta");
        requestDTO.setPassword("abcd");
        requestDTO.setEmail("mamta@gmail.com");

        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();

        UserSignUpResponseDTO userSignUpResponseDTO1 = userController.signUp(requestDTO);
        System.out.println(userSignUpResponseDTO1.getId());
    }

    @Test
    public void testLogin(){
        UserLoginRequestDTO requestDTO = new UserLoginRequestDTO();
        requestDTO.setEmail("mamta@gmail.com");
        requestDTO.setPassword("abcd");
        UserLoginResponseDTO loginResponseDTO = userController.login(requestDTO);
        if(loginResponseDTO.getBookingStatus().equals(BookingStatus.CONFIRMED)){
            System.out.println("LOGIN SUCCESSFUL");
        }
        else{
            System.out.println("Login unsuccessful");
        }
    }

}

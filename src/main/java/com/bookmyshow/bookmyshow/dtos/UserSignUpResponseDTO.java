package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private long id;
    private String name;
    private String email;
    private List<Ticket> tickets;

}

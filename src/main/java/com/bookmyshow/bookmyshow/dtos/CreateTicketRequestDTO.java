package com.bookmyshow.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateTicketRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}

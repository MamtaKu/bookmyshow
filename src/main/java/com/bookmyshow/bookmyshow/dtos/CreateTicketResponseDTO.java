package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTicketResponseDTO {
    private Long ticketId;
    private BookingStatus bookingStatus;
    private double amount;
}

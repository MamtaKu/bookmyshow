package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Basemodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @CreatedDate
//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    @LastModifiedBy
//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date updatedAt;
}

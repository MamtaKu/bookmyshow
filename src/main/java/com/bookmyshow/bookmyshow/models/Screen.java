package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.FeatureEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends Basemodel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection(targetClass = FeatureEnum.class)
    @CollectionTable(
            name = "screen_feature",
            joinColumns = @JoinColumn(name = "screen_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "feature_type")
    private List<FeatureEnum> features;
}

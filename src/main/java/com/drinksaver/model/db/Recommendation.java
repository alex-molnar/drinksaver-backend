package com.drinksaver.model.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recommendations")
@NoArgsConstructor
@Getter
@Setter
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String name;
    private Integer alcoholTypeId;
    private Integer alcoholVolumeId;
    private Integer brandId;
    private Integer consumptionTypeId;
}

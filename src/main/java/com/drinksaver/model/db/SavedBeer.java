package com.drinksaver.model.db;

import com.drinksaver.model.dto.Beer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saved_beers")
@NoArgsConstructor
@Getter
@Setter
public class SavedBeer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String date;
    private Integer alcoholTypeId;
    private Integer alcoholVolumeId;
    private Integer brandId;
    private Integer consumptionTypeId;
    private String comments;

    public SavedBeer(Integer userId, String date, Integer alcoholTypeId, Integer alcoholVolumeId, Integer brandId, Integer consumptionTypeId, String comments) {
        this.userId = userId;
        this.date = date;
        this.alcoholTypeId = alcoholTypeId;
        this.alcoholVolumeId = alcoholVolumeId;
        this.brandId = brandId;
        this.consumptionTypeId = consumptionTypeId;
        this.comments = comments;
    }

    public SavedBeer withId(Integer id) {
        this.id = id;
        return this;
    }

    public static SavedBeer of(Beer beer) {
        return new SavedBeer(
                beer.userId(),
                beer.date(),
                beer.alcoholTypeId(),
                beer.alcoholVolumeId(),
                beer.brandId(),
                beer.consumptionTypeId(),
                beer.comments()
        );
    }

}

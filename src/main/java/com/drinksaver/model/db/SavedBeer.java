package com.drinksaver.model.db;

import com.drinksaver.model.dto.Beer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "saved_beers")
@NoArgsConstructor
@Getter
@Setter
public class SavedBeer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID userId;
    private String date;
    private Integer alcoholTypeId;
    private Integer alcoholSubtypeId;
    private Integer alcoholVolumeId;
    private Integer brandId;
    private Integer beerFlavourId;
    private Integer consumptionTypeId;
    private String comments;

    public SavedBeer(UUID userId, String date, Integer alcoholTypeId, Integer alcoholSubtypeId, Integer alcoholVolumeId, Integer brandId, Integer beerFlavourId, Integer consumptionTypeId, String comments) {
        this.userId = userId;
        this.date = date;
        this.alcoholTypeId = alcoholTypeId;
        this.alcoholSubtypeId = alcoholSubtypeId;
        this.alcoholVolumeId = alcoholVolumeId;
        this.brandId = brandId;
        this.beerFlavourId = beerFlavourId;
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
                beer.alcoholSubtypeId(),
                beer.alcoholVolumeId(),
                beer.brandId(),
                beer.beerFlavourId(),
                beer.consumptionTypeId(),
                beer.comments()
        );
    }

}

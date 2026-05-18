package com.drinksaver.service.model;

import com.drinksaver.model.db.Recommendation;
import com.drinksaver.model.db.SavedDrink;

import java.util.Optional;
import java.util.UUID;

public record DrinkKey(
        Integer alcoholTypeId,
        Integer alcoholSubtypeId,
        Integer alcoholVolumeId,
        Integer brandId,
        Integer beerFlavourId,
        Integer consumptionTypeId,
        Optional<String> name
) {
    public Recommendation toRecommendation(UUID userId) {
        Recommendation recommendation = new Recommendation();
        recommendation.setUserId(userId);
        recommendation.setName(name.orElse("Couldn't generate name"));
        recommendation.setAlcoholTypeId(alcoholTypeId);
        recommendation.setAlcoholSubtypeId(alcoholSubtypeId);
        recommendation.setAlcoholVolumeId(alcoholVolumeId);
        recommendation.setBrandId(brandId);
        recommendation.setBeerFlavourId(beerFlavourId);
        recommendation.setConsumptionTypeId(consumptionTypeId);
        return recommendation;
    }

    public DrinkKey withName(String name) {
        return new DrinkKey(
                alcoholTypeId,
                alcoholSubtypeId,
                alcoholVolumeId,
                brandId,
                beerFlavourId,
                consumptionTypeId,
                Optional.of(name)
        );
    }

    public static DrinkKey of(SavedDrink drink) {
        return new DrinkKey(
                drink.getAlcoholTypeId(),
                drink.getAlcoholSubtypeId(),
                drink.getAlcoholVolumeId(),
                null,
                null,
                null,
                Optional.empty()
        );
    }

    public static DrinkKey of(Recommendation recommendation) {
        return new DrinkKey(
                recommendation.getAlcoholTypeId(),
                recommendation.getAlcoholSubtypeId(),
                recommendation.getAlcoholVolumeId(),
                recommendation.getBrandId(),
                recommendation.getBeerFlavourId(),
                recommendation.getConsumptionTypeId(),
                Optional.ofNullable(recommendation.getName())
        );
    }
}

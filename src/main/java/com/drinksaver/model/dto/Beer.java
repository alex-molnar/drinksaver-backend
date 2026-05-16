package com.drinksaver.model.dto;

import java.util.UUID;

public record Beer(
        UUID userId,
        String date,
        Integer alcoholTypeId,
        Integer alcoholSubtypeId,
        Integer alcoholVolumeId,
        Integer brandId,
        Integer beerFlavourId,
        Integer consumptionTypeId,
        String comments,
        Integer quantity
) {
    public Drink asDrink() {
        return new Drink(userId, date, alcoholTypeId, alcoholSubtypeId, alcoholVolumeId, comments, quantity);
    }
}

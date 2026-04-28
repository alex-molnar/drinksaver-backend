package com.drinksaver.model.dto;

import java.util.UUID;

public record Beer(UUID userId, String date, Integer alcoholTypeId, Integer alcoholVolumeId, Integer brandId, Integer consumptionTypeId, String comments) {
    public Drink asDrink() {
        return new Drink(userId, date, alcoholTypeId, alcoholVolumeId, comments);
    }
}

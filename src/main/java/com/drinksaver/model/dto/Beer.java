package com.drinksaver.model.dto;

public record Beer(String date, Integer alcoholTypeId, Integer alcoholVolumeId, Integer brandId, Integer consumptionTypeId, String comments) {
    public Drink asDrink() {
        return new Drink(date, alcoholTypeId, alcoholVolumeId, comments);
    }
}

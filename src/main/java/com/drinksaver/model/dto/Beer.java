package com.drinksaver.model.dto;

public record Beer(Integer userId, String date, Integer alcoholTypeId, Integer alcoholVolumeId, Integer brandId, Integer consumptionTypeId, String comments) {
    public Drink asDrink() {
        return new Drink(userId, date, alcoholTypeId, alcoholVolumeId, comments);
    }
}

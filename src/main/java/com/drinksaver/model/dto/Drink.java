package com.drinksaver.model.dto;


public record Drink(Integer userId, String date, Integer alcoholTypeId, Integer alcoholVolumeId, String comments) {}

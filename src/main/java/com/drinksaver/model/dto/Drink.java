package com.drinksaver.model.dto;


import java.util.UUID;

public record Drink(
        UUID userId,
        String date,
        Integer alcoholTypeId,
        Integer alcoholSubtypeId,
        Integer alcoholVolumeId,
        String comments,
        Integer quantity
) {}

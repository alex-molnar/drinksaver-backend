package com.drinksaver.model.dto;

import java.util.List;

public record NewAlcoholEntry(String name, List<Integer> VolumeIds) {}

package com.drinksaver.repository;

import com.drinksaver.model.db.Brand;
import com.drinksaver.model.db.ConsumptionType;
import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.dto.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerRepository {
    boolean is(String repositoryType);
    List<Brand> getBrands(UUID userId);
    List<ConsumptionType> getConsumptionTypes(Integer maxAmount);
    Brand saveBrand(UUID userId, String name);
    SavedBeer saveBeer(Beer beer);
}


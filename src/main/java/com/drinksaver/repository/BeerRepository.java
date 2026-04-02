package com.drinksaver.repository;

import com.drinksaver.model.db.Brand;
import com.drinksaver.model.db.ConsumptionType;
import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.dto.Beer;

import java.util.List;

public interface BeerRepository {
    boolean is(String repositoryType);
    List<Brand> getBrands(Integer maxAmount);
    List<ConsumptionType> getConsumptionTypes(Integer maxAmount);
    Brand saveBrand(String name);
    SavedBeer saveBeer(Beer beer);
}


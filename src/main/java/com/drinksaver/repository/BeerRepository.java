package com.drinksaver.repository;

import com.drinksaver.model.dto.Beer;
import com.drinksaver.model.dto.SingleNameResponse;

import java.util.List;

public interface BeerRepository {
    boolean is(String repositoryType);
    List<SingleNameResponse> getBrands(Integer maxAmount);
    List<SingleNameResponse> getConsumptionTypes(Integer maxAmount);
    SingleNameResponse saveBrand(String name);
    Beer saveBeer(Beer beer);
}


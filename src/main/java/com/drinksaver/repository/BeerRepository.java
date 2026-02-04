package com.drinksaver.repository;

import com.drinksaver.model.SingleNameResponse;

import java.util.List;

public interface BeerRepository {
    boolean is(String repositoryType);
    List<SingleNameResponse> getBrands(Integer maxAmount);
    List<SingleNameResponse> getConsumptionTypes(Integer maxAmount);
}


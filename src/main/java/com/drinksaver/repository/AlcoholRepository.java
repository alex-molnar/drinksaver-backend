package com.drinksaver.repository;

import com.drinksaver.model.SingleNameResponse;

import java.util.List;

public interface AlcoholRepository {
    boolean is(String repositoryType);
    List<SingleNameResponse> getAlcoholTypes(Integer maxAmount);
}

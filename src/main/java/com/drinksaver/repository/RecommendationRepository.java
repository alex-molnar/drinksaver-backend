package com.drinksaver.repository;

import com.drinksaver.model.SingleNameResponse;

import java.util.List;

public interface RecommendationRepository {
    boolean is(String repositoryType);
    List<SingleNameResponse> getRecommendations(Integer maxAmount);
}

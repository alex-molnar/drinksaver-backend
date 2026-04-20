package com.drinksaver.repository;

import com.drinksaver.model.db.Recommendation;

import java.util.List;

public interface RecommendationRepository {
    boolean is(String repositoryType);
    List<Recommendation> getRecommendations(Integer userId);
}

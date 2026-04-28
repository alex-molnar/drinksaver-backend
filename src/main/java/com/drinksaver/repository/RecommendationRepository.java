package com.drinksaver.repository;

import com.drinksaver.model.db.Recommendation;

import java.util.List;
import java.util.UUID;

public interface RecommendationRepository {
    boolean is(String repositoryType);
    List<Recommendation> getRecommendations(UUID userId);
}

package com.drinksaver.service;

import com.drinksaver.repository.AlcoholRepository;
import com.drinksaver.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InjectorService {

    private final Map<String, RecommendationRepository> recommendationsRepositories;
    private final Map<String, AlcoholRepository> alcoholRepositories;

    @Autowired
    public InjectorService(
            Map<String, RecommendationRepository> recommendationsRepositories,
            Map<String, AlcoholRepository> alcoholRepositories
    ) {
        this.recommendationsRepositories = recommendationsRepositories;
        this.alcoholRepositories = alcoholRepositories;
    }

    public RecommendationRepository getRecommendationsRepository(String name) {
        return recommendationsRepositories
                .values()
                .stream()
                .filter(repo -> repo.is(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such RecommendationRepository: " + name));
    }

    public AlcoholRepository getAlcoholRepository(String name) {
        return alcoholRepositories
                .values()
                .stream()
                .filter(repo -> repo.is(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such AlcoholRepository: " + name));
    }
}

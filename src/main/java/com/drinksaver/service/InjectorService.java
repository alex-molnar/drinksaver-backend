package com.drinksaver.service;

import com.drinksaver.repository.AlcoholRepository;
import com.drinksaver.repository.BeerRepository;
import com.drinksaver.repository.DrinksRepository;
import com.drinksaver.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InjectorService {

    private final Map<String, RecommendationRepository> recommendationsRepositories;
    private final Map<String, AlcoholRepository> alcoholRepositories;
    private final Map<String, BeerRepository> beerRepositories;
    private final Map<String, DrinksRepository> drinksRepositories;

    @Autowired
    public InjectorService(
            Map<String, RecommendationRepository> recommendationsRepositories,
            Map<String, AlcoholRepository> alcoholRepositories,
            Map<String, BeerRepository> beerRepositories,
            Map<String, DrinksRepository> drinksRepositories
    ) {
        this.recommendationsRepositories = recommendationsRepositories;
        this.alcoholRepositories = alcoholRepositories;
        this.beerRepositories = beerRepositories;
        this.drinksRepositories = drinksRepositories;
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

    public BeerRepository getBeerRepository(String name) {
        return beerRepositories
                .values()
                .stream()
                .filter(repo -> repo.is(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such BeerRepository: " + name));
    }

    public DrinksRepository getDrinksRepository(String name) {
        return drinksRepositories
                .values()
                .stream()
                .filter(repo -> repo.is(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such DrinksRepository: " + name));
    }
}

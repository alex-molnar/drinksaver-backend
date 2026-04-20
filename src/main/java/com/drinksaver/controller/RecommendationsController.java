package com.drinksaver.controller;

import com.drinksaver.model.db.Recommendation;
import com.drinksaver.repository.RecommendationRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/recommendations")
public class RecommendationsController {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationsController(InjectorService injectorService) {
        this.recommendationRepository = injectorService.getRecommendationsRepository();
    }

    @GetMapping("/{userId}/list")
    public List<Recommendation> getRecommendationsList(@PathVariable Integer userId) {
        return recommendationRepository.getRecommendations(userId);
    }
}


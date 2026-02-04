package com.drinksaver.controller;

import com.drinksaver.model.SingleNameResponse;
import com.drinksaver.repository.RecommendationRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/recommendations")
public class RecommendationsController {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationsController(InjectorService injectorService) {
        this.recommendationRepository = injectorService.getRecommendationsRepository("hardcoded");
    }

    @GetMapping("/list")
    public List<SingleNameResponse> getRecommendationsList(@RequestParam(defaultValue = "10") Integer amount) {
        return recommendationRepository.getRecommendations(amount);
    }
}


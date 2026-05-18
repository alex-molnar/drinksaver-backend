package com.drinksaver.controller;

import com.drinksaver.model.db.SavedDrink;
import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.DrinksRepository;
import com.drinksaver.service.InjectorService;
import com.drinksaver.service.RecommendationCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/drinks")
public class DrinksController {

    private final DrinksRepository drinksRepository;
    private final RecommendationCacheService recommendationCacheService;

    @Autowired
    public DrinksController(InjectorService injectorService, RecommendationCacheService recommendationCacheService) {
        this.drinksRepository = injectorService.getDrinksRepository();
        this.recommendationCacheService = recommendationCacheService;
    }

    @PostMapping("/new")
    public SavedDrink saveDrink(@RequestBody Drink drink) {
        SavedDrink saved = drinksRepository.saveDrink(drink);
        recommendationCacheService.onDrinkSaved(drink);
        return saved;
    }
}


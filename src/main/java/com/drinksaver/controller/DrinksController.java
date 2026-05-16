package com.drinksaver.controller;

import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.db.SavedDrink;
import com.drinksaver.model.dto.Beer;
import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.BeerRepository;
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
    private final BeerRepository beerRepository;
    private final RecommendationCacheService recommendationCacheService;

    @Autowired
    public DrinksController(InjectorService injectorService, RecommendationCacheService recommendationCacheService) {
        this.drinksRepository = injectorService.getDrinksRepository();
        this.beerRepository = injectorService.getBeerRepository();
        this.recommendationCacheService = recommendationCacheService;
    }

    @PostMapping("/new")
    public SavedDrink saveDrink(@RequestBody Drink drink) {
        SavedDrink saved = drinksRepository.saveDrink(drink);
        recommendationCacheService.onDrinkSaved(drink);
        return saved;
    }

    @PostMapping("/beer/new")
    public SavedBeer saveBeer(@RequestBody Beer beer) {
        // TODO off beer table
        drinksRepository.saveDrink(beer.asDrink());
        SavedBeer saved = beerRepository.saveBeer(beer);
        recommendationCacheService.onDrinkSaved(beer.asDrink());
        return saved;
    }

}


package com.drinksaver.controller;

import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.db.SavedDrink;
import com.drinksaver.model.dto.Beer;
import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.BeerRepository;
import com.drinksaver.repository.DrinksRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/v1/drinks")
public class DrinksController {

    private final DrinksRepository drinksRepository;
    private final BeerRepository beerRepository;

    @Autowired
    public DrinksController(InjectorService injectorService) {
        this.drinksRepository = injectorService.getDrinksRepository();
        this.beerRepository = injectorService.getBeerRepository();
    }

    @PostMapping("/new")
    public SavedDrink saveDrink(@RequestBody Drink drink) {
        return drinksRepository.saveDrink(drink);
    }

    @PostMapping("/beer/new")
    public SavedBeer saveBeer(@RequestBody Beer beer) {
        // TODO in transaction
        drinksRepository.saveDrink(beer.asDrink());
        return beerRepository.saveBeer(beer);
    }

}


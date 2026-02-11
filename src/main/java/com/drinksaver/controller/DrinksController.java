package com.drinksaver.controller;

import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.DrinksRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/drinks")
public class DrinksController {

    private final DrinksRepository drinksRepository;

    @Autowired
    public DrinksController(InjectorService injectorService) {
        this.drinksRepository = injectorService.getDrinksRepository("hardcoded");
    }

    @PostMapping("/new")
    public Drink saveDrink(@RequestBody Drink drink) {
        return drinksRepository.saveDrink(drink);
    }
}


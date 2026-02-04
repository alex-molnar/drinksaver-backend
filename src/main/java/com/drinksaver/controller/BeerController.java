package com.drinksaver.controller;

import com.drinksaver.model.SingleNameResponse;
import com.drinksaver.repository.BeerRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/beer")
public class BeerController {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerController(InjectorService injectorService) {
        this.beerRepository = injectorService.getBeerRepository("hardcoded");
    }

    @GetMapping("/brands")
    public List<SingleNameResponse> getBrandsList(@RequestParam(defaultValue = "10") Integer amount) {
        return beerRepository.getBrands(amount);
    }

    @GetMapping("/consumption-types")
    public List<SingleNameResponse> getConsumptionTypesList(@RequestParam(defaultValue = "10") Integer amount) {
        return beerRepository.getConsumptionTypes(amount);
    }
}


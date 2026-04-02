package com.drinksaver.controller;

import com.drinksaver.model.db.Brand;
import com.drinksaver.model.db.ConsumptionType;
import com.drinksaver.repository.BeerRepository;
import com.drinksaver.service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Brand> getBrandsList(@RequestParam(defaultValue = "10") Integer amount) {
        return beerRepository.getBrands(amount);
    }

    @GetMapping("/consumption-types")
    public List<ConsumptionType> getConsumptionTypesList(@RequestParam(defaultValue = "10") Integer amount) {
        return beerRepository.getConsumptionTypes(amount);
    }

    @PostMapping("/brands/{brand}")
    public Brand saveBrand(@PathVariable String brand) {
        return beerRepository.saveBrand(brand);
    }
}


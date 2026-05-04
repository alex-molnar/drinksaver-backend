package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.db.Brand;
import com.drinksaver.model.db.ConsumptionType;
import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.dto.Beer;
import com.drinksaver.repository.BeerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class HardcodedBeerRepository implements BeerRepository {

    private static final Map<Integer, String> BEER_BRANDS = new LinkedHashMap<>();
    private static final List<SavedBeer> BEERS = new ArrayList<>();
    private static int nextBrandId = 1;
    private static int nextBeerId = 1;

    static {
        BEER_BRANDS.put(nextBrandId++, "Heineken");
        BEER_BRANDS.put(nextBrandId++, "Corona");
        BEER_BRANDS.put(nextBrandId++, "Budweiser");
        BEER_BRANDS.put(nextBrandId++, "Stella Artois");
        BEER_BRANDS.put(nextBrandId++, "Guinness");
        BEER_BRANDS.put(nextBrandId++, "Chouffe");
        BEER_BRANDS.put(nextBrandId++, "Pilsner Urquell");
        BEER_BRANDS.put(nextBrandId++, "Leffe");
        BEER_BRANDS.put(nextBrandId++, "Hoegaarden");
        BEER_BRANDS.put(nextBrandId++, "Duvel");
        BEER_BRANDS.put(nextBrandId++, "Chimay");
        BEER_BRANDS.put(nextBrandId++, "Paulaner");
        BEER_BRANDS.put(nextBrandId++, "Carlsberg");
        BEER_BRANDS.put(nextBrandId++, "Peroni");
        BEER_BRANDS.put(nextBrandId++, "San Miguel");
        BEER_BRANDS.put(nextBrandId++, "Asahi");
        BEER_BRANDS.put(nextBrandId++, "Kirin");
        BEER_BRANDS.put(nextBrandId++, "Sapporo");
        BEER_BRANDS.put(nextBrandId++, "Tsingtao");
        BEER_BRANDS.put(nextBrandId++, "Tiger");
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<Brand> getBrands(UUID userId) {
        return BEER_BRANDS.entrySet().stream()
                .map(entry -> new Brand(entry.getKey(), userId, entry.getValue()))
                .toList();
    }

    @Override
    public List<ConsumptionType> getConsumptionTypes(Integer maxAmount) {
        return Stream.of(
                new ConsumptionType(1, "Bottle"),
                new ConsumptionType(2, "Can"),
                new ConsumptionType(3, "Draft/Tap"),
                new ConsumptionType(4, "Pint"),
                new ConsumptionType(5, "Half Pint"),
                new ConsumptionType(6, "Small Glass (250ml)"),
                new ConsumptionType(7, "Large Glass (500ml)"),
                new ConsumptionType(8, "Pitcher"),
                new ConsumptionType(9, "Growler"),
                new ConsumptionType(10, "Keg"))
        .limit(maxAmount)
        .toList();
    }

    @Override
    public Brand saveBrand(UUID userId, String name) {
        int newId = nextBrandId++;
        BEER_BRANDS.put(newId, name);
        return new Brand(newId, userId, name);
    }

    @Override
    public SavedBeer saveBeer(Beer beer) {
        SavedBeer savedBeer = SavedBeer.of(beer).withId(nextBeerId++);
        BEERS.add(savedBeer);
        return savedBeer;
    }
}


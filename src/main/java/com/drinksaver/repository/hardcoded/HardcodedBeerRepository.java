package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.dto.SingleNameResponse;
import com.drinksaver.repository.BeerRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class HardcodedBeerRepository implements BeerRepository {

    private static final Map<Integer, String> BEER_BRANDS = new LinkedHashMap<>();
    private static int nextBrandId = 1;

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
    public List<SingleNameResponse> getBrands(Integer maxAmount) {
        return BEER_BRANDS.entrySet().stream()
                .map(entry -> new SingleNameResponse(entry.getKey(), entry.getValue()))
                .limit(maxAmount)
                .toList();
    }

    @Override
    public List<SingleNameResponse> getConsumptionTypes(Integer maxAmount) {
        return Stream.of(
                new SingleNameResponse(1, "Bottle"),
                new SingleNameResponse(2, "Can"),
                new SingleNameResponse(3, "Draft/Tap"),
                new SingleNameResponse(4, "Pint"),
                new SingleNameResponse(5, "Half Pint"),
                new SingleNameResponse(6, "Small Glass (250ml)"),
                new SingleNameResponse(7, "Large Glass (500ml)"),
                new SingleNameResponse(8, "Pitcher"),
                new SingleNameResponse(9, "Growler"),
                new SingleNameResponse(10, "Keg"))
        .limit(maxAmount)
        .toList();
    }

    @Override
    public SingleNameResponse saveBrand(String name) {
        int newId = nextBrandId++;
        BEER_BRANDS.put(newId, name);
        return new SingleNameResponse(newId, name);
    }
}


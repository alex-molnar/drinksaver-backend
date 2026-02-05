package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.dto.SingleNameResponse;
import com.drinksaver.repository.BeerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class HardcodedBeerRepository implements BeerRepository {
    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<SingleNameResponse> getBrands(Integer maxAmount) {
        return Stream.of(
                new SingleNameResponse(1, "Heineken"),
                new SingleNameResponse(2, "Corona"),
                new SingleNameResponse(3, "Budweiser"),
                new SingleNameResponse(4, "Stella Artois"),
                new SingleNameResponse(5, "Guinness"),
                new SingleNameResponse(6, "Chouffe"),
                new SingleNameResponse(7, "Pilsner Urquell"),
                new SingleNameResponse(8, "Leffe"),
                new SingleNameResponse(9, "Hoegaarden"),
                new SingleNameResponse(10, "Duvel"),
                new SingleNameResponse(11, "Chimay"),
                new SingleNameResponse(12, "Paulaner"),
                new SingleNameResponse(13, "Carlsberg"),
                new SingleNameResponse(14, "Peroni"),
                new SingleNameResponse(15, "San Miguel"),
                new SingleNameResponse(16, "Asahi"),
                new SingleNameResponse(17, "Kirin"),
                new SingleNameResponse(18, "Sapporo"),
                new SingleNameResponse(19, "Tsingtao"),
                new SingleNameResponse(20, "Tiger"))
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
}


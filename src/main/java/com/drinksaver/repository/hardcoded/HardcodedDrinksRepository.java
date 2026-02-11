package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.DrinksRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HardcodedDrinksRepository implements DrinksRepository {

    private static final List<Drink> DRINKS = new ArrayList<>();

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public Drink saveDrink(Drink drink) {
        DRINKS.add(drink);
        return drink;
    }
}


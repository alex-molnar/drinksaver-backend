package com.drinksaver.repository;

import com.drinksaver.model.dto.Drink;

public interface DrinksRepository {
    boolean is(String repositoryType);
    Drink saveDrink(Drink drink);
}


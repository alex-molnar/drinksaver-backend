package com.drinksaver.repository;

import com.drinksaver.model.db.SavedDrink;
import com.drinksaver.model.dto.Drink;

public interface DrinksRepository {
    boolean is(String repositoryType);
    SavedDrink saveDrink(Drink drink);
}


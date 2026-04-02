package com.drinksaver.repository.postgres;

import com.drinksaver.model.db.SavedDrink;
import com.drinksaver.model.dto.Drink;
import com.drinksaver.repository.DrinksRepository;
import com.drinksaver.repository.postgres.schema.SavedDrinksTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresDrinksRepository implements DrinksRepository {
    private final SavedDrinksTable savedDrinksTable;

    @Autowired
    PostgresDrinksRepository(SavedDrinksTable savedDrinksTable) {
        this.savedDrinksTable = savedDrinksTable;
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("postgres");
    }

    @Override
    public SavedDrink saveDrink(Drink drink) {
        return savedDrinksTable.save(SavedDrink.of(drink));
    }
}

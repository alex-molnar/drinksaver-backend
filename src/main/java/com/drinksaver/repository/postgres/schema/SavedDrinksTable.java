package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.SavedDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedDrinksTable extends JpaRepository<SavedDrink, Integer> {}

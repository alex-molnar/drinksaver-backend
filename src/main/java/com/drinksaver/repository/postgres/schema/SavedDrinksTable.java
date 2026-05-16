package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.SavedDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SavedDrinksTable extends JpaRepository<SavedDrink, Integer> {
    List<SavedDrink> findByUserId(UUID userId);
}

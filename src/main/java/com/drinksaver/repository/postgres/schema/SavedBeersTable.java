package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.SavedBeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedBeersTable extends JpaRepository<SavedBeer, Integer> {
    List<SavedBeer> findByUserId(java.util.UUID userId);
}

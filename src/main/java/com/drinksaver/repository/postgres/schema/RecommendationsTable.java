package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationsTable extends JpaRepository<Recommendation, Integer> {}

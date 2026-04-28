package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecommendationsTable extends JpaRepository<Recommendation, Integer> {
    List<Recommendation> getRecommendationsByUserId(UUID userId);
}

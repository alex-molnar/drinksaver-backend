package com.drinksaver.repository.postgres;

import com.drinksaver.model.db.Recommendation;
import com.drinksaver.model.dto.SingleNameResponse;
import com.drinksaver.repository.RecommendationRepository;
import com.drinksaver.repository.postgres.schema.RecommendationsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresRecommendationRepository implements RecommendationRepository {
    private final RecommendationsTable recommendationsTable;

    @Autowired
    PostgresRecommendationRepository(
            RecommendationsTable recommendationsTable
    ) {
        this.recommendationsTable = recommendationsTable;
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("postgres");
    }

    @Override
    public List<SingleNameResponse> getRecommendations(Integer maxAmount) {
        return recommendationsTable.findAll(PageRequest.of(0, maxAmount))
                .stream()
                .map(Recommendation::asSingleNameResponse)
                .toList();
    }
}

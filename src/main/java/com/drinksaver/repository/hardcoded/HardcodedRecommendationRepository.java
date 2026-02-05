package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.dto.SingleNameResponse;
import com.drinksaver.repository.RecommendationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class HardcodedRecommendationRepository implements RecommendationRepository {
    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<SingleNameResponse> getRecommendations(Integer maxAmount) {
        return Stream.of(
            new SingleNameResponse(1, "Office HJ"),
            new SingleNameResponse(2, "Office Chouffe"),
            new SingleNameResponse(3, "Office Corona"),
            new SingleNameResponse(4, "Small Heineken"),
            new SingleNameResponse(5, "Heineken Pint"),
            new SingleNameResponse(6, "Biergarten Pilsner"),
            new SingleNameResponse(7, "Biergarten Weizen"))
         .limit(maxAmount)
         .toList();
    }
}

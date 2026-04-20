package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.db.Recommendation;
import com.drinksaver.repository.RecommendationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardcodedRecommendationRepository implements RecommendationRepository {
    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<Recommendation> getRecommendations(Integer userId) {
        return List.of(
                new Recommendation() {{
                    setId(1);
                    setUserId(userId);
                    setName("Recommendation 1");
                    setAlcoholTypeId(1);
                    setAlcoholVolumeId(1);
                    setBrandId(1);
                    setConsumptionTypeId(1);
                }},
                new Recommendation() {{
                    setId(2);
                    setUserId(userId);
                    setName("Recommendation 2");
                    setAlcoholTypeId(2);
                    setAlcoholVolumeId(2);
                    setBrandId(2);
                    setConsumptionTypeId(2);
                }}
        );
    }
}

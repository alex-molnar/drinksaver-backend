package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.SingleNameResponse;
import com.drinksaver.repository.AlcoholRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class HardcodedAlcoholRepository implements AlcoholRepository {
    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<SingleNameResponse> getAlcoholTypes(Integer maxAmount) {
        return Stream.of(
                new SingleNameResponse(1, "beer"),
                new SingleNameResponse(2, "cider"),
                new SingleNameResponse(3, "spirit"),
                new SingleNameResponse(4, "champagne"),
                new SingleNameResponse(5, "red wine"),
                new SingleNameResponse(6, "cocktail"),
                new SingleNameResponse(7, "cognac"),
                new SingleNameResponse(8, "mixed shot"),
                new SingleNameResponse(9, "chacha"),
                new SingleNameResponse(10, "Piana Vyshnia"),
                new SingleNameResponse(11, "limoncello"),
                new SingleNameResponse(12, "vodka"),
                new SingleNameResponse(13, "Zubrowka"),
                new SingleNameResponse(14, "prosecco"),
                new SingleNameResponse(15, "palinka"),
                new SingleNameResponse(16, "white wine"),
                new SingleNameResponse(17, "aperitif"),
                new SingleNameResponse(18, "digestive"),
                new SingleNameResponse(19, "whiskey"),
                new SingleNameResponse(20, "seltzer"),
                new SingleNameResponse(21, "ouzo"),
                new SingleNameResponse(22, "Tubi"),
                new SingleNameResponse(23, "froccs"),
                new SingleNameResponse(24, "Ukrainian Honey"),
                new SingleNameResponse(25, "soju"))
        .limit(maxAmount)
        .toList();
    }
}

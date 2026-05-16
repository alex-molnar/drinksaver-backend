package com.drinksaver.service.recommendations;

import com.drinksaver.config.RepositoryConfiguration;
import com.drinksaver.repository.postgres.schema.SavedBeersTable;
import com.drinksaver.repository.postgres.schema.SavedDrinksTable;
import com.drinksaver.service.model.DrinkKey;
import com.drinksaver.service.recommendations.api.RecommendationSource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonalRecommendationSource implements RecommendationSource {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    private final RepositoryConfiguration repositoryConfiguration;
    private final SavedDrinksTable savedDrinksTable;
    private final SavedBeersTable savedBeersTable;

    public PersonalRecommendationSource(
        RepositoryConfiguration repositoryConfiguration,
        SavedDrinksTable savedDrinksTable,
        SavedBeersTable savedBeersTable
    ) {
        this.repositoryConfiguration = repositoryConfiguration;
        this.savedDrinksTable = savedDrinksTable;
        this.savedBeersTable = savedBeersTable;
    }

    @Override
    public Map<DrinkKey, Double> buildRecommendation(UUID userId) {
        LocalDate today = LocalDate.now();

        return Stream.concat(
            savedDrinksTable
                .findByUserId(userId)
                .stream()
                .filter(drink -> !drink.getAlcoholTypeId().equals(repositoryConfiguration.beerId())) // Exclude beers from saved drinks
                .map(drink -> new AbstractMap.SimpleEntry<DrinkKey, Double>(
                        DrinkKey.of(drink),
                        Math.pow(repositoryConfiguration.decayFactor(), calculateDaysSince(drink.getDate(), today))
                )),
            savedBeersTable
                .findByUserId(userId)
                .stream()
                .map(beer -> new AbstractMap.SimpleEntry<DrinkKey, Double>(
                        DrinkKey.of(beer),
                        Math.pow(repositoryConfiguration.decayFactor(), calculateDaysSince(beer.getDate(), today))
                ))
        ).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            Double::sum
        ));
    }

    private long calculateDaysSince(String dateStr, LocalDate today) {
        if (dateStr == null || dateStr.isBlank()) {
            return 30; // Default to 30 days for missing dates
        }
        try {
            LocalDate drinkDate = LocalDate.parse(dateStr, DATE_FORMATTER);
            return Math.max(0, ChronoUnit.DAYS.between(drinkDate, today));
        } catch (DateTimeParseException e) {
            return 30; // Default for unparseable dates
        }
    }
}

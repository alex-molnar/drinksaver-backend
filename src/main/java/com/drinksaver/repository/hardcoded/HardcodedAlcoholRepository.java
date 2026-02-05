package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.dto.AlcoholVolumeDescription;
import com.drinksaver.model.dto.SingleNameResponse;
import com.drinksaver.repository.AlcoholRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HardcodedAlcoholRepository implements AlcoholRepository {

    private static final Map<Integer, AlcoholType> ALCOHOL_TYPES = new LinkedHashMap<>();

    static {
        ALCOHOL_TYPES.put(1, new AlcoholType(1, "beer", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small bottle", 0.33f),
                new AlcoholVolumeDescription("large bottle", 0.5f),
                new AlcoholVolumeDescription("pint", 0.568f),
                new AlcoholVolumeDescription("small glass", 0.25f)
        ))));
        ALCOHOL_TYPES.put(2, new AlcoholType(2, "cider", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small bottle", 0.33f),
                new AlcoholVolumeDescription("large bottle", 0.5f),
                new AlcoholVolumeDescription("pint", 0.568f)
        ))));
        ALCOHOL_TYPES.put(3, new AlcoholType(3, "spirit", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single shot", 0.025f),
                new AlcoholVolumeDescription("standard shot", 0.035f),
                new AlcoholVolumeDescription("double shot", 0.05f)
        ))));
        ALCOHOL_TYPES.put(4, new AlcoholType(4, "champagne", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small glass", 0.125f),
                new AlcoholVolumeDescription("standard glass", 0.15f),
                new AlcoholVolumeDescription("bottle", 0.75f)
        ))));
        ALCOHOL_TYPES.put(5, new AlcoholType(5, "red wine", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small glass", 0.125f),
                new AlcoholVolumeDescription("medium glass", 0.175f),
                new AlcoholVolumeDescription("large glass", 0.25f),
                new AlcoholVolumeDescription("bottle", 0.75f)
        ))));
//        ALCOHOL_TYPES.put(6, new AlcoholType(6, "cocktail", new ArrayList<>(List.of(
//                new AlcoholVolumeDescription("small", 0.2f),
//                new AlcoholVolumeDescription("medium", 0.25f),
//                new AlcoholVolumeDescription("large", 0.3f)
//        ))));
        ALCOHOL_TYPES.put(7, new AlcoholType(7, "cognac", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single", 0.025f),
                new AlcoholVolumeDescription("double", 0.05f)
        ))));
        ALCOHOL_TYPES.put(8, new AlcoholType(8, "mixed shot", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small", 0.03f),
                new AlcoholVolumeDescription("standard", 0.05f),
                new AlcoholVolumeDescription("large", 0.06f)
        ))));
        ALCOHOL_TYPES.put(9, new AlcoholType(9, "chacha", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("double", 0.1f)
        ))));
        ALCOHOL_TYPES.put(10, new AlcoholType(10, "Piana Vyshnia", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("double", 0.1f)
        ))));
        ALCOHOL_TYPES.put(11, new AlcoholType(11, "limoncello", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small shot", 0.03f),
                new AlcoholVolumeDescription("standard shot", 0.05f),
                new AlcoholVolumeDescription("large shot", 0.075f)
        ))));
        ALCOHOL_TYPES.put(12, new AlcoholType(12, "vodka", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single shot", 0.025f),
                new AlcoholVolumeDescription("double shot", 0.05f),
                new AlcoholVolumeDescription("triple shot", 0.1f)
        ))));
        ALCOHOL_TYPES.put(13, new AlcoholType(13, "Zubrowka", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single shot", 0.025f),
                new AlcoholVolumeDescription("double shot", 0.05f),
                new AlcoholVolumeDescription("triple shot", 0.1f)
        ))));
        ALCOHOL_TYPES.put(14, new AlcoholType(14, "prosecco", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small glass", 0.125f),
                new AlcoholVolumeDescription("standard glass", 0.15f),
                new AlcoholVolumeDescription("bottle", 0.75f)
        ))));
        ALCOHOL_TYPES.put(15, new AlcoholType(15, "palinka", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single shot", 0.025f),
                new AlcoholVolumeDescription("double shot", 0.05f),
                new AlcoholVolumeDescription("triple shot", 0.1f)
        ))));
        ALCOHOL_TYPES.put(16, new AlcoholType(16, "white wine", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small glass", 0.125f),
                new AlcoholVolumeDescription("medium glass", 0.175f),
                new AlcoholVolumeDescription("large glass", 0.25f),
                new AlcoholVolumeDescription("bottle", 0.75f)
        ))));
        ALCOHOL_TYPES.put(17, new AlcoholType(17, "aperitif", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small", 0.05f),
                new AlcoholVolumeDescription("medium", 0.075f),
                new AlcoholVolumeDescription("large", 0.1f)
        ))));
        ALCOHOL_TYPES.put(18, new AlcoholType(18, "digestive", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single", 0.025f),
                new AlcoholVolumeDescription("double", 0.05f)
        ))));
        ALCOHOL_TYPES.put(19, new AlcoholType(19, "whiskey", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("single shot", 0.025f),
                new AlcoholVolumeDescription("standard shot", 0.035f),
                new AlcoholVolumeDescription("double shot", 0.05f)
        ))));
        ALCOHOL_TYPES.put(20, new AlcoholType(20, "seltzer", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small can", 0.33f),
                new AlcoholVolumeDescription("standard can", 0.355f),
                new AlcoholVolumeDescription("large can", 0.473f)
        ))));
        ALCOHOL_TYPES.put(21, new AlcoholType(21, "ouzo", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("double", 0.1f)
        ))));
        ALCOHOL_TYPES.put(22, new AlcoholType(22, "Tubi", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("double", 0.1f)
        ))));
        ALCOHOL_TYPES.put(23, new AlcoholType(23, "froccs", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("small", 0.2f),
                new AlcoholVolumeDescription("medium", 0.3f),
                new AlcoholVolumeDescription("large", 0.5f)
        ))));
        ALCOHOL_TYPES.put(24, new AlcoholType(24, "Ukrainian Honey", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("double", 0.1f)
        ))));
        ALCOHOL_TYPES.put(25, new AlcoholType(25, "soju", new ArrayList<>(List.of(
                new AlcoholVolumeDescription("shot", 0.05f),
                new AlcoholVolumeDescription("glass", 0.1f),
                new AlcoholVolumeDescription("bottle", 0.36f)
        ))));
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<SingleNameResponse> getAlcoholTypes(Integer maxAmount) {
        return ALCOHOL_TYPES.values().stream()
                .map(alcoholType -> new SingleNameResponse(alcoholType.id, alcoholType.name))
                .limit(maxAmount)
                .toList();
    }

    @Override
    public List<AlcoholVolumeDescription> getVolumesByAlcoholType(Integer alcoholTypeId) {
        AlcoholType alcoholType = ALCOHOL_TYPES.get(alcoholTypeId);
        return alcoholType != null ? alcoholType.volumes : List.of();
    }

    @Override
    public AlcoholVolumeDescription saveVolumeForAlcoholType(Integer alcoholTypeId, String name, Float volume) {
        AlcoholType alcoholType = ALCOHOL_TYPES.get(alcoholTypeId);
        if (alcoholType == null) {
            throw new IllegalArgumentException("Alcohol type with id " + alcoholTypeId + " not found");
        }

        AlcoholVolumeDescription newVolume = new AlcoholVolumeDescription(name, volume);
        alcoholType.volumes.add(newVolume);
        return newVolume;
    }

    @Override
    public SingleNameResponse createAlcoholType(String name, List<Integer> volumeIds) {
        // Generate new ID
        int newId = ALCOHOL_TYPES.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0) + 1;

        // Create volumes list - empty if volumeIds is null or empty
        List<AlcoholVolumeDescription> volumes = new ArrayList<>();
        if (volumeIds != null && !volumeIds.isEmpty()) {
            // Get volumes from existing alcohol types based on volumeIds
            // This allows reusing common volume descriptions
            for (Integer volumeId : volumeIds) {
                ALCOHOL_TYPES.values().stream()
                        .flatMap(type -> type.volumes.stream())
                        .skip(volumeId - 1)
                        .findFirst()
                        .ifPresent(volumes::add);
            }
        }

        // Create and store new alcohol type
        AlcoholType newAlcoholType = new AlcoholType(newId, name, volumes);
        ALCOHOL_TYPES.put(newId, newAlcoholType);

        return new SingleNameResponse(newId, name);
    }

    private record AlcoholType(int id, String name, List<AlcoholVolumeDescription> volumes) {}
}

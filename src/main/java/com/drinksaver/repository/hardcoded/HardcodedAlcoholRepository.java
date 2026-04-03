package com.drinksaver.repository.hardcoded;

import com.drinksaver.model.db.AlcoholType;
import com.drinksaver.model.db.AlcoholVolume;
import com.drinksaver.model.dto.NewAlcoholEntry;
import com.drinksaver.model.dto.NewVolumeEntry;
import com.drinksaver.repository.AlcoholRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HardcodedAlcoholRepository implements AlcoholRepository {

    private static final Map<Integer, AlcoholVolume> ALCOHOL_VOLUMES = new LinkedHashMap<>();
    private static final Map<Integer, AlcoholType> ALCOHOL_TYPES = new LinkedHashMap<>();
    private static int nextVolumeId = 1;

    static {
        // Initialize volumes first
        int v1 = addVolume("small bottle", 0.33f);
        int v2 = addVolume("large bottle", 0.5f);
        int v3 = addVolume("pint", 0.568f);
        int v4 = addVolume("small glass", 0.25f);
        int v5 = addVolume("single shot", 0.025f);
        int v6 = addVolume("standard shot", 0.035f);
        int v7 = addVolume("double shot", 0.05f);
        int v8 = addVolume("standard glass", 0.15f);
        int v9 = addVolume("bottle", 0.75f);
        int v10 = addVolume("medium glass", 0.175f);
        int v11 = addVolume("large glass", 0.25f);
        int v12 = addVolume("single", 0.025f);
        int v13 = addVolume("double", 0.05f);
        int v14 = addVolume("small", 0.03f);
        int v15 = addVolume("standard", 0.05f);
        int v16 = addVolume("large", 0.06f);
        int v17 = addVolume("shot", 0.05f);
        int v18 = addVolume("double", 0.1f);
        int v19 = addVolume("small shot", 0.03f);
        int v20 = addVolume("large shot", 0.075f);
        int v21 = addVolume("triple shot", 0.1f);
        int v22 = addVolume("small can", 0.33f);
        int v23 = addVolume("standard can", 0.355f);
        int v24 = addVolume("large can", 0.473f);
        int v25 = addVolume("small", 0.2f);
        int v26 = addVolume("medium", 0.3f);
        int v27 = addVolume("large", 0.5f);
        int v28 = addVolume("glass", 0.1f);
        int v29 = addVolume("bottle", 0.36f);
        int v30 = addVolume("small", 0.05f);
        int v31 = addVolume("medium", 0.075f);
        int v32 = addVolume("large", 0.1f);

        // Initialize alcohol types with volume IDs
        ALCOHOL_TYPES.put(1, new AlcoholType(1, "beer", new ArrayList<>(List.of(v1, v2, v3, v4))));
        ALCOHOL_TYPES.put(2, new AlcoholType(2, "cider", new ArrayList<>(List.of(v1, v2, v3))));
        ALCOHOL_TYPES.put(3, new AlcoholType(3, "spirit", new ArrayList<>(List.of(v5, v6, v7))));
        ALCOHOL_TYPES.put(4, new AlcoholType(4, "champagne", new ArrayList<>(List.of(v4, v8, v9))));
        ALCOHOL_TYPES.put(5, new AlcoholType(5, "red wine", new ArrayList<>(List.of(v4, v10, v11, v9))));
        ALCOHOL_TYPES.put(7, new AlcoholType(7, "cognac", new ArrayList<>(List.of(v12, v13))));
        ALCOHOL_TYPES.put(8, new AlcoholType(8, "mixed shot", new ArrayList<>(List.of(v14, v15, v16))));
        ALCOHOL_TYPES.put(9, new AlcoholType(9, "chacha", new ArrayList<>(List.of(v17, v18))));
        ALCOHOL_TYPES.put(10, new AlcoholType(10, "Piana Vyshnia", new ArrayList<>(List.of(v17, v18))));
        ALCOHOL_TYPES.put(11, new AlcoholType(11, "limoncello", new ArrayList<>(List.of(v19, v15, v20))));
        ALCOHOL_TYPES.put(12, new AlcoholType(12, "vodka", new ArrayList<>(List.of(v5, v7, v21))));
        ALCOHOL_TYPES.put(13, new AlcoholType(13, "Zubrowka", new ArrayList<>(List.of(v5, v7, v21))));
        ALCOHOL_TYPES.put(14, new AlcoholType(14, "prosecco", new ArrayList<>(List.of(v4, v8, v9))));
        ALCOHOL_TYPES.put(15, new AlcoholType(15, "palinka", new ArrayList<>(List.of(v5, v7, v21))));
        ALCOHOL_TYPES.put(16, new AlcoholType(16, "white wine", new ArrayList<>(List.of(v4, v10, v11, v9))));
        ALCOHOL_TYPES.put(17, new AlcoholType(17, "aperitif", new ArrayList<>(List.of(v30, v31, v32))));
        ALCOHOL_TYPES.put(18, new AlcoholType(18, "digestive", new ArrayList<>(List.of(v12, v13))));
        ALCOHOL_TYPES.put(19, new AlcoholType(19, "whiskey", new ArrayList<>(List.of(v5, v6, v7))));
        ALCOHOL_TYPES.put(20, new AlcoholType(20, "seltzer", new ArrayList<>(List.of(v22, v23, v24))));
        ALCOHOL_TYPES.put(21, new AlcoholType(21, "ouzo", new ArrayList<>(List.of(v17, v18))));
        ALCOHOL_TYPES.put(22, new AlcoholType(22, "Tubi", new ArrayList<>(List.of(v17, v18))));
        ALCOHOL_TYPES.put(23, new AlcoholType(23, "froccs", new ArrayList<>(List.of(v25, v26, v27))));
        ALCOHOL_TYPES.put(24, new AlcoholType(24, "Ukrainian Honey", new ArrayList<>(List.of(v17, v18))));
        ALCOHOL_TYPES.put(25, new AlcoholType(25, "soju", new ArrayList<>(List.of(v17, v28, v29))));
    }

    private static int addVolume(String name, float volume) {
        int id = nextVolumeId++;
        ALCOHOL_VOLUMES.put(id, new AlcoholVolume(name, volume));
        return id;
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("hardcoded");
    }

    @Override
    public List<AlcoholType> getAlcoholTypes(Integer maxAmount) {
        return ALCOHOL_TYPES.values().stream()
                .limit(maxAmount)
                .toList();
    }

    @Override
    public List<AlcoholVolume> getVolumesByAlcoholType(Integer alcoholTypeId) {
        AlcoholType alcoholType = ALCOHOL_TYPES.get(alcoholTypeId);
        if (alcoholType == null) {
            return List.of();
        }

        return alcoholType.getVolumeIds().stream()
                .map(ALCOHOL_VOLUMES::get)
                .filter(java.util.Objects::nonNull)
                .toList();
    }

    @Override
    public AlcoholVolume saveVolumeForAlcoholType(Integer alcoholTypeId, NewVolumeEntry volumeDescription) {
        AlcoholType alcoholType = ALCOHOL_TYPES.get(alcoholTypeId);
        if (alcoholType == null) {
            throw new IllegalArgumentException("Alcohol type with id " + alcoholTypeId + " not found");
        }

        // Create new volume and add to ALCOHOL_VOLUMES map
        int newVolumeId = nextVolumeId++;
        AlcoholVolume newVolume = new AlcoholVolume(volumeDescription.name(), volumeDescription.volume());
        ALCOHOL_VOLUMES.put(newVolumeId, newVolume);

        // Add volume ID to alcohol type
        alcoholType.getVolumeIds().add(newVolumeId);

        return newVolume;
    }

    @Override
    public AlcoholType createAlcoholType(NewAlcoholEntry newAlcoholEntry) {
        // Generate new ID
        int newId = ALCOHOL_TYPES.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0) + 1;

        // Create volume IDs list - empty if volumeIds is null or empty
        List<Integer> volumeIdsList = newAlcoholEntry.volumes().stream().map(nve -> addVolume(nve.name(), nve.volume())).toList();

        // Create and store new alcohol type
        AlcoholType newAlcoholType = new AlcoholType(newId, newAlcoholEntry.name(), volumeIdsList);
        ALCOHOL_TYPES.put(newId, newAlcoholType);

        return newAlcoholType;
    }
}

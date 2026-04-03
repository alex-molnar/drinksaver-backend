package com.drinksaver.repository;

import com.drinksaver.model.db.AlcoholType;
import com.drinksaver.model.db.AlcoholVolume;
import com.drinksaver.model.dto.NewAlcoholEntry;
import com.drinksaver.model.dto.NewVolumeEntry;

import java.util.List;

public interface AlcoholRepository {
    boolean is(String repositoryType);
    List<AlcoholType> getAlcoholTypes(Integer maxAmount);
    List<AlcoholVolume> getVolumesByAlcoholType(Integer alcoholTypeId);
    AlcoholVolume saveVolumeForAlcoholType(Integer alcoholTypeId, NewVolumeEntry volumeDescription);
    AlcoholType createAlcoholType(NewAlcoholEntry newAlcoholEntry);
}

package com.drinksaver.repository;

import com.drinksaver.model.AlcoholVolumeDescription;
import com.drinksaver.model.SingleNameResponse;

import java.util.List;

public interface AlcoholRepository {
    boolean is(String repositoryType);
    List<SingleNameResponse> getAlcoholTypes(Integer maxAmount);
    List<AlcoholVolumeDescription> getVolumesByAlcoholType(Integer alcoholTypeId);
    AlcoholVolumeDescription saveVolumeForAlcoholType(Integer alcoholTypeId, String name, Float volume);
}

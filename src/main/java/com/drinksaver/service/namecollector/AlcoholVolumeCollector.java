package com.drinksaver.service.namecollector;

import com.drinksaver.model.db.AlcoholVolume;
import com.drinksaver.repository.postgres.schema.AlcoholVolumeTable;
import org.springframework.stereotype.Service;

@Service
public class AlcoholVolumeCollector {
    private final AlcoholVolumeTable alcoholVolumeTable;

    public AlcoholVolumeCollector(AlcoholVolumeTable alcoholVolumeTable) {
        this.alcoholVolumeTable = alcoholVolumeTable;
    }

    public String getAlcoholVolumeName(Integer alcoholVolumeId) {
        return alcoholVolumeTable
            .findById(alcoholVolumeId)
            .map(volume -> String.format("(%s - %.2fl)", volume.getName(), volume.getVolume()))
            .orElse("Unknown volume");

    }
}

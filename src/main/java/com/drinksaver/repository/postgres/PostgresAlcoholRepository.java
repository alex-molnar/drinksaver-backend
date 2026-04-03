package com.drinksaver.repository.postgres;

import com.drinksaver.model.db.AlcoholType;
import com.drinksaver.model.db.AlcoholVolume;
import com.drinksaver.model.dto.NewAlcoholEntry;
import com.drinksaver.model.dto.NewVolumeEntry;
import com.drinksaver.repository.AlcoholRepository;
import com.drinksaver.repository.postgres.schema.AlcoholTypesTable;
import com.drinksaver.repository.postgres.schema.AlcoholVolumeTable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresAlcoholRepository implements AlcoholRepository {
    private final AlcoholTypesTable alcoholTypesTable;
    private final AlcoholVolumeTable alcoholVolumeTable;

    public PostgresAlcoholRepository(AlcoholTypesTable alcoholTypesTable, AlcoholVolumeTable alcoholVolumeTable) {
        this.alcoholTypesTable = alcoholTypesTable;
        this.alcoholVolumeTable = alcoholVolumeTable;
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equalsIgnoreCase("postgres");
    }

    @Override
    public List<AlcoholType> getAlcoholTypes(Integer maxAmount) {
        return alcoholTypesTable.findAll(Pageable.ofSize(maxAmount)).toList();
    }

    @Override
    public List<AlcoholVolume> getVolumesByAlcoholType(Integer alcoholTypeId) {
        return alcoholTypesTable
                .findById(alcoholTypeId)
                .map(alcoholType -> alcoholVolumeTable.findAllById(alcoholType.getVolumeIds()))
                .orElse(List.of());
    }

    @Override
    public AlcoholVolume saveVolumeForAlcoholType(Integer alcoholTypeId, NewVolumeEntry volumeDescription) {
        return alcoholTypesTable.findById(alcoholTypeId)
                .map(alcoholType -> {
                    AlcoholVolume savedVolume = alcoholVolumeTable.save(AlcoholVolume.of(volumeDescription));
                    alcoholType.getVolumeIds().add(savedVolume.getId());
                    alcoholTypesTable.save(alcoholType);
                    return savedVolume;
                })
                .orElse(new AlcoholVolume()); // TODO ResponseEntity 404
    }

    @Override
    public AlcoholType createAlcoholType(NewAlcoholEntry newAlcoholEntry) {
        // TODO in transaction
        List<Integer> volumeIds = newAlcoholEntry.volumes()
                .stream()
                .map(newEntry -> alcoholVolumeTable.save(AlcoholVolume.of(newEntry)).getId())
                .toList();
        return alcoholTypesTable.save(new AlcoholType(newAlcoholEntry.name(), volumeIds));
    }
}

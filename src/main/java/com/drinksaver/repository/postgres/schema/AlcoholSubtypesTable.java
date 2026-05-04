package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.AlcoholSubtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholSubtypesTable extends JpaRepository<AlcoholSubtype, Integer> {
    List<AlcoholSubtype> findAllByAlcoholTypeIdAndUserId(Integer alcoholTypeId, java.util.UUID userId);
}

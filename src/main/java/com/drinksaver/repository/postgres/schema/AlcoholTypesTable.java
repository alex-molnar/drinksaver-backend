package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.AlcoholType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholTypesTable extends JpaRepository<AlcoholType, Integer> {}

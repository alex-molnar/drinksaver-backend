package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.ConsumptionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionTypesTable extends JpaRepository<ConsumptionType, Integer> {}

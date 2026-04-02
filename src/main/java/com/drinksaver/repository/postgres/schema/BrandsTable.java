package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsTable extends JpaRepository<Brand, Integer> {}

package com.drinksaver.repository.postgres.schema;

import com.drinksaver.model.db.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandsTable extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByUserId(java.util.UUID userId);
}

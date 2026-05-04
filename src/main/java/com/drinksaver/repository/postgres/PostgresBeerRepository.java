package com.drinksaver.repository.postgres;

import com.drinksaver.model.db.BeerFlavour;
import com.drinksaver.model.db.Brand;
import com.drinksaver.model.db.ConsumptionType;
import com.drinksaver.model.db.SavedBeer;
import com.drinksaver.model.dto.Beer;
import com.drinksaver.repository.BeerRepository;
import com.drinksaver.repository.postgres.schema.BeerFlavoursTable;
import com.drinksaver.repository.postgres.schema.BrandsTable;
import com.drinksaver.repository.postgres.schema.ConsumptionTypesTable;
import com.drinksaver.repository.postgres.schema.SavedBeersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class PostgresBeerRepository implements BeerRepository {
    private final static UUID SHARED_USER_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    private final BrandsTable brandsTable;
    private final ConsumptionTypesTable consumptionTypesTable;
    private final SavedBeersTable savedBeersTable;
    private final BeerFlavoursTable beerFlavoursTable;

    @Autowired
    public PostgresBeerRepository(
            BrandsTable brandsTable,
            ConsumptionTypesTable consumptionTypesTable,
            SavedBeersTable savedBeersTable,
            BeerFlavoursTable beerFlavoursTable
    ) {
        this.brandsTable = brandsTable;
        this.consumptionTypesTable = consumptionTypesTable;
        this.savedBeersTable = savedBeersTable;
        this.beerFlavoursTable = beerFlavoursTable;
    }

    @Override
    public boolean is(String repositoryType) {
        return repositoryType.equals("postgres");
    }

    @Override
    public List<Brand> getBrands(UUID userId) {
        return Stream.concat(
            brandsTable.findAllByUserId(userId).stream(),
            brandsTable.findAllByUserId(SHARED_USER_ID).stream()
        ).toList();
    }

    @Override
    public List<ConsumptionType> getConsumptionTypes(Integer maxAmount) {
        return consumptionTypesTable.findAll(Pageable.ofSize(maxAmount)).toList();
    }

    @Override
    public Brand saveBrand(UUID userId, String name, List<String> flavours) {
        Brand result = brandsTable.save(new Brand(userId, name));
        beerFlavoursTable.saveAll(
            flavours
                .stream()
                .map(flavour -> new BeerFlavour(result.getId(), userId, flavour))
                .toList()
        );
        return result;
    }

    @Override
    public List<BeerFlavour> getBeerFlavours(Integer brandId, UUID userId) {
        return Stream.concat(
            beerFlavoursTable.findAllByBrandIdAndUserId(brandId, SHARED_USER_ID).stream(),
            beerFlavoursTable.findAllByBrandIdAndUserId(brandId, userId).stream()
        ).toList();
    }

    @Override
    public BeerFlavour saveBeerFlavour(Integer brandId, UUID userId, String name) {
        return beerFlavoursTable.save(new BeerFlavour(brandId, userId, name));
    }

    @Override
    public SavedBeer saveBeer(Beer beer) {
        return savedBeersTable.save(SavedBeer.of(beer));
    }
}

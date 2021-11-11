package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VinylService extends GeneralService<Vinyl>{
    Page<Vinyl> findAll(Pageable pageable);

    Page<Vinyl> findAllByVinylName(String vinylName, Pageable pageable);

    Page<Vinyl> findAllByDiscountGreaterThan(Long discount, Pageable pageable);

    Page<Vinyl> findAllByRealPriceLessThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByRealPriceGreaterThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByNation(Nation nation, Pageable pageable);

    Page<Vinyl> findAllByGenre(Genre genre, Pageable pageable, String sort, String direction);

    Iterable<Vinyl> findAllWithList();

    Optional<Vinyl> findById(Long id);

    void save(Vinyl vinyl);

    void remove(Long id);
}

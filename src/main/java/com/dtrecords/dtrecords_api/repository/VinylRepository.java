package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinylRepository extends JpaRepository<Vinyl, Long> {
    Page<Vinyl> findAll(Pageable pageable);

    Iterable<Vinyl> findTop10ByQuantityBetweenOrderByIdDesc(Long quantity, Long quantity2);

    Iterable<Vinyl> findAllByArtistAndIdNotLikeAndQuantityAfter(Artist artist, Long id, Long quantity);

    Iterable<Vinyl> findAllByArtistAndQuantityAfter(Artist artist, Long quantity);

    Iterable<Vinyl> findAllByDiscountAfterAndQuantityAfterOrderByIdDesc(Long discount, Long quantity);

    Iterable<Vinyl> findAllByNationAndIdNotLike(Nation nation, Long id);

    Iterable<Vinyl> findAllByNation(Nation nation);

    Page<Vinyl> findAllByVinylName(String vinylName, Pageable pageable);

    Page<Vinyl> findAllByDiscountGreaterThan(Long discount, Pageable pageable);

    Page<Vinyl> findAllByRealPriceLessThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByRealPriceGreaterThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByNation(Nation nation, Pageable pageable);
}

package com.dtrecords.dtrecords_api.service;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VinylService extends GeneralService<Vinyl>{
    Page<Vinyl> findAll(Pageable pageable);

    Iterable<Vinyl> findTop10ByQuantityBetweenOrderByIdDesc(Long quantity, Long quantity2);

    Iterable<Vinyl> findAllByArtistAndIdNotLikeAndQuantityAfter(Artist artist, Long id, Long quantity);

    Iterable<Vinyl> findAllByArtistAndQuantityAfterWithoutCurrentVinyl(Artist artist, Long id, Long quantity);

    Iterable<Vinyl> findAllByDiscountAfterAndQuantityAfterOrderByIdDesc(Long discount, Long quantity);

    Iterable<Vinyl> findAllByNationAndIdNotLike(Nation nation, Long id);

    Iterable<Vinyl> findAllByTheSameNationWithoutCurrentVinyl(Nation nation, Long id);

    Page<Vinyl> findAllByVinylName(String vinylName, Pageable pageable);

    Page<Vinyl> findAllByDiscountGreaterThan(Long discount, Pageable pageable);

    Page<Vinyl> findAllByRealPriceLessThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByRealPriceGreaterThanEqual(Double realPrice, Pageable pageable);

    Page<Vinyl> findAllByNation(Nation nation, Pageable pageable);

    Page<Vinyl> findAllByGenre(Genre genre, Pageable pageable, String sort, String direction);

    List<Vinyl> findAllByTheSameGenreVinyl(Vinyl vinyl);

    Optional<Vinyl> findById(Long id);

    void save(Vinyl vinyl);

    void remove(Long id);
}

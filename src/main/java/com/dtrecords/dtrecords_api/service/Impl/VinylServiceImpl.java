package com.dtrecords.dtrecords_api.service.Impl;

import com.dtrecords.dtrecords_api.domain.Artist;
import com.dtrecords.dtrecords_api.domain.Genre;
import com.dtrecords.dtrecords_api.domain.Nation;
import com.dtrecords.dtrecords_api.domain.Vinyl;
import com.dtrecords.dtrecords_api.repository.VinylRepository;
import com.dtrecords.dtrecords_api.service.VinylService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VinylServiceImpl implements VinylService {
    private final VinylRepository vinylRepository;

    @Override
    public Page<Vinyl> findAll(Pageable pageable) {
        return vinylRepository.findAll(pageable);
    }

    @Override
    public Iterable<Vinyl> findTop10ByQuantityBetweenOrderByIdDesc(Long quantity, Long quantity2) {
        return vinylRepository.findTop10ByQuantityBetweenOrderByIdDesc(quantity,quantity2);
    }

    @Override
    public Iterable<Vinyl> findAllByArtistAndIdNotLikeAndQuantityAfter(Artist artist, Long id, Long quantity) {
        return vinylRepository.findAllByArtistAndIdNotLikeAndQuantityAfter(artist,id,quantity);
    }

    @Override
    public Iterable<Vinyl> findAllByDiscountAfterAndQuantityAfterOrderByIdDesc(Long discount, Long quantity) {
        return vinylRepository.findAllByDiscountAfterAndQuantityAfterOrderByIdDesc(discount, quantity);
    }

    @Override
    public Iterable<Vinyl> findAllByNationAndIdNotLike(Nation nation, Long id) {
        return vinylRepository.findAllByNationAndIdNotLike(nation, id);
    }

    @Override
    public Page<Vinyl> findAllByVinylName(String vinylName, Pageable pageable) {
        return vinylRepository.findAllByVinylName(vinylName,pageable);
    }

    @Override
    public Page<Vinyl> findAllByDiscountGreaterThan(Long discount, Pageable pageable) {
        return vinylRepository.findAllByDiscountGreaterThan(discount,pageable);
    }

    @Override
    public Page<Vinyl> findAllByRealPriceLessThanEqual(Double realPrice, Pageable pageable) {
        return vinylRepository.findAllByRealPriceLessThanEqual(realPrice,pageable);
    }

    @Override
    public Page<Vinyl> findAllByRealPriceGreaterThanEqual(Double realPrice, Pageable pageable) {
        return vinylRepository.findAllByRealPriceGreaterThanEqual(realPrice,pageable);
    }

    @Override
    public Page<Vinyl> findAllByNation(Nation nation, Pageable pageable) {
        return vinylRepository.findAllByNation(nation,pageable);
    }

    @Override
    public Page<Vinyl> findAllByGenre(Genre genre, Pageable pageable, String sort, String direction) {
        List<Vinyl> VinylsWithTheSameGenre = new ArrayList<>();
        List<Vinyl> allVinyls = vinylRepository.findAll();
        allVinyls.forEach(vinyl -> {
            if (vinyl.getGenres().contains(genre)) {
                VinylsWithTheSameGenre.add(vinyl);
            }
        });
        int start = (int) pageable.getOffset();
        int end = (Math.min((start + pageable.getPageSize()), VinylsWithTheSameGenre.size()));
        if (sort != null && direction != null) {
            Comparator<Vinyl> comparatorById = (Vinyl vinyl1, Vinyl vinyl2) -> vinyl1.getId().compareTo(vinyl2.getId());
            Comparator<Vinyl> comparatorByRealPrice = (Vinyl vinyl1, Vinyl vinyl2) -> vinyl1.getRealPrice().compareTo(vinyl2.getRealPrice());
            if (direction.equalsIgnoreCase("asc")) {
                if (sort.equalsIgnoreCase("id")) {
                    VinylsWithTheSameGenre.sort(comparatorById);
                }
                if (sort.equalsIgnoreCase("realPrice")) {
                    VinylsWithTheSameGenre.sort(comparatorByRealPrice);
                }
            } else {
                if (sort.equalsIgnoreCase("id")) {
                    VinylsWithTheSameGenre.sort(comparatorById.reversed());
                }
                if (sort.equalsIgnoreCase("realPrice")) {
                    VinylsWithTheSameGenre.sort(comparatorByRealPrice.reversed());
                }
            }
        }
        return new PageImpl<Vinyl>(VinylsWithTheSameGenre.subList(start,end), pageable , VinylsWithTheSameGenre.size());
    }

    @Override
    public List<Vinyl> findAllByTheSameGenreVinyl(Vinyl vinyl) {
        List<Vinyl> theSameGenreVinyls = new ArrayList<>();
        List<Vinyl> vinyls = vinylRepository.findAll();
        for (Genre genre : vinyl.getGenres()) {
            vinyls.forEach(v -> {
                if (v.getGenres().contains(genre) && v.getQuantity() > 0 && v!= vinyl) {
                    theSameGenreVinyls.add(v);
                }
            });
        }
        return theSameGenreVinyls;
    }

    @Override
    public Iterable<Vinyl> findAll() {
        return vinylRepository.findAll();
    }

    @Override
    public Optional<Vinyl> findById(Long id) {
        return vinylRepository.findById(id);
    }

    @Override
    public void save(Vinyl vinyl) {
        vinyl.setRealPrice(Math.round((vinyl.getPrice() - (vinyl.getPrice() * vinyl.getDiscount()) / 100) * 100.0) / 100.0);
        vinylRepository.save(vinyl);
    }

    @Override
    public void remove(Long id) {
        vinylRepository.deleteById(id);
    }
}

package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query(nativeQuery = true, value = "select * from artist order by random() limit :limitNum")
    Iterable<Artist> findRandomArtists(@Param("limitNum") Integer limitNum);
}

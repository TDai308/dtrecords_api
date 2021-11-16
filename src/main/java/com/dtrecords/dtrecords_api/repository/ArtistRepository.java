package com.dtrecords.dtrecords_api.repository;

import com.dtrecords.dtrecords_api.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query(nativeQuery = true, value = "select * from artist order by rand() limit 5")
    Iterable<Artist> findRandomArtists();
}

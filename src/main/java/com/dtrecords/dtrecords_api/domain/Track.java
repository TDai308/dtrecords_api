package com.dtrecords.dtrecords_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackName;
    @ManyToMany
    private Collection<Artist> artists = new ArrayList<>();
    @ManyToOne
    private Vinyl vinyl;
}

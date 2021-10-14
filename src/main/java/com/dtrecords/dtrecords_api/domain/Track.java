package com.dtrecords.dtrecords_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackName;
    private String artists;
    private String trackPreview;
    @ManyToOne
    @JoinColumn(name = "vinyl_id")
    private Vinyl vinyl;
}

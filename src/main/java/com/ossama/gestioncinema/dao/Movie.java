package com.ossama.gestioncinema.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double duration;
    private String directorName;
    private String description;
    private String picture;
    @Temporal(value=TemporalType.DATE)
    private Date realisationDate;
    @OneToMany(mappedBy = "movie")
    private List<MovieProjection> movieProjection=new ArrayList<>();
    @ManyToOne
    private Category category;
}

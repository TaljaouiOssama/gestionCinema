package com.ossama.gestioncinema.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @ToString @AllArgsConstructor @NoArgsConstructor
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double longitude,latitude,altitude;
    private int nbrTheater;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "cinema")
    private List<Theater> theaterList=new ArrayList<>();
}

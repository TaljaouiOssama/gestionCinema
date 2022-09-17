package com.ossama.gestioncinema.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Theater implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private int nbrSeats;
    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy = "theater")
    private List<Seat> seatList=new ArrayList<>();
    @OneToMany(mappedBy = "theater")
    private List<MovieProjection> movieProjection=new ArrayList<>();


}

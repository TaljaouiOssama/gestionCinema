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
public class MovieProjection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(value=TemporalType.DATE)
    private Date projectionDate;
    private double price;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Theater theater;
    @OneToOne
    private Session session;
    @OneToMany(mappedBy = "movieProjection")
    private List<Ticket> ticketList=new ArrayList<>();

}

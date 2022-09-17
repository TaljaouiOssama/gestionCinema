package com.ossama.gestioncinema.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clientName;
    private double price;
    private int pricingCode;
    private boolean isReserved;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private MovieProjection movieProjection;
}

package com.mobiservices.test.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReservation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="id_trajet", referencedColumnName="idTrajet"),
            @JoinColumn(name="date_trajet", referencedColumnName="dateTrajet")
    })
    private Trajet trajet;
}

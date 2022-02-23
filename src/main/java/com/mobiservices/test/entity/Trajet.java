package com.mobiservices.test.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "trajets")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trajet {


    @Id
    @Column ( name = "id_trajet")
    private String idTrajet;

    @Column ( name = "date_trajet")
    private LocalDate dateTrajet;

    @Column ( name = "heure_depart_trajet")
    private LocalDateTime heureDepartTrajet;

    @Column ( name = "prix_trajet")
    private long prix;

    @Column ( name = "nombre_places")
    private int nombrePlaces;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bus bus;
}

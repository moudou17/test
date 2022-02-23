package com.mobiservices.test.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBill;

    @Column ( name = "date_Bill")
    private LocalDate dateBill;

    @Column ( name = "prix_bill")
    private long prixBill;

    private boolean remise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Reservation reservation;

    private long numeroCartePayement;

    private LocalDate dateExpirationCartePayement;

    private String emailPaypal;
}

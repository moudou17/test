package com.mobiservices.test.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bus {

    @Id
    @Column(name = "numero_bus")
    private long numeroBus;

    @Column(name = "type_bus")
    private String typeBus;
}

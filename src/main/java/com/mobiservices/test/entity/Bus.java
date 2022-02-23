package com.mobiservices.test.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Bus {

    @Id
    @Column(name = "numero_bus")
    private long numeroBus;

    @Column(name = "type_bus")
    private String typeBus;
}

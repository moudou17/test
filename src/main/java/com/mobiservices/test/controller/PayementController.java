package com.mobiservices.test.controller;

import com.mobiservices.test.entity.Reservation;
import com.mobiservices.test.exception.ResourceNotFoundException;
import com.mobiservices.test.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PayementController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/payements/{id}")
    public Boolean payReservation(@PathVariable(value = "id") Long ReservationId){
        return true ;
    }



}

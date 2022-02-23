package com.mobiservices.test.controller;

import com.mobiservices.test.entity.Reservation;
import com.mobiservices.test.exception.ResourceNotFoundException;
import com.mobiservices.test.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    @Autowired
    private ReservationRepository ReservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservation() {
        return ReservationRepository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity< Reservation > getReservationById(@PathVariable(value = "id") Long ReservationId)
            throws ResourceNotFoundException {
        Reservation Reservation = ReservationRepository.findById(ReservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation n'est pas trouvé pour l'id :: " + ReservationId));
        return ResponseEntity.ok().body(Reservation);
    }

    @PostMapping("/reservations")
    public Reservation createReservation(@Valid @RequestBody Reservation Reservation) {
        return ReservationRepository.save(Reservation);
    }


    @DeleteMapping("/reservations/{id}")
    public Map< String, Boolean > deleteReservation(@PathVariable(value = "id") Long ReservationId)
            throws ResourceNotFoundException {
        Reservation Reservation = ReservationRepository.findById(ReservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation non trouvé avec cet id: " + ReservationId));

        ReservationRepository.delete(Reservation);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

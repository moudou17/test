package com.mobiservices.test.controller;

import com.mobiservices.test.entity.Bus;
import com.mobiservices.test.exception.ResourceNotFoundException;
import com.mobiservices.test.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BusController {

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/bus")
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity< Bus > getBusById(@PathVariable(value = "id") Long busId)
            throws ResourceNotFoundException {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus n'est pas trouvé pour l'id :: " + busId));
        return ResponseEntity.ok().body(bus);
    }

    @PostMapping("/bus")
    public Bus createBus(@Valid @RequestBody Bus bus) {
        return busRepository.save(bus);
    }


    @DeleteMapping("/bus/{id}")
    public Map< String, Boolean > deleteBus(@PathVariable(value = "id") Long busId)
            throws ResourceNotFoundException {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus non trouvé avec cet id: " + busId));

        busRepository.delete(bus);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

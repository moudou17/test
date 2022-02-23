package com.mobiservices.test.controller;

import com.mobiservices.test.entity.Bus;
import com.mobiservices.test.exception.ResourceNotFoundException;
import com.mobiservices.test.repository.BusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BusControllerTest {

    @Autowired
    BusController busController;

    @SpyBean
    private BusRepository busRepository;

    @Mock
    Bus bus;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllBus() {
    }

    @Test
    void getBusById() throws ResourceNotFoundException {

        Bus busToSave = new Bus(2, "Renault");
        Bus busResponse = busController.createBus(busToSave);
        ResponseEntity<Bus> busResponseEntity = busController.getBusById(busToSave.getNumeroBus());

        assertThat(busResponse.getNumeroBus())
               .isEqualTo(busToSave.getNumeroBus());
        assertThat(busResponseEntity.getBody().getNumeroBus()).isEqualTo(2);
    }

    @Test
    void createBus() {

        Bus busToSave = new Bus(1, "Volvo");
        Bus busResponse = busController.createBus(busToSave);

        assertThat(busResponse.getTypeBus())
                .isEqualTo("Volvo");

    }

    @Test
    void deleteBus() {
    }
}
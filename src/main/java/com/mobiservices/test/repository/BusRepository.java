package com.mobiservices.test.repository;

import com.mobiservices.test.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    @Override
    List<Bus> findAll();

}

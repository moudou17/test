package com.mobiservices.test.repository;

import com.mobiservices.test.entity.Bill;
import com.mobiservices.test.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository <Bill, Long> {

}

package com.mobiservices.test.controller;

import com.mobiservices.test.entity.Bill;
import com.mobiservices.test.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class BillController {

    @Autowired
    private BillRepository BillRepository;

    @GetMapping("/bills")
    public List<Bill> getAllBill() {
        return BillRepository.findAll().stream().sorted().collect(Collectors.toList());
    }
}

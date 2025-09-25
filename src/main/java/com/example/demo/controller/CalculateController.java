package com.example.demo.controller;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Scanner;

@RestController
@RequestMapping("/api/calculate")
public class CalculateController {
    private CalculatorServiceImpl calculatorService;

    @Autowired
    public CalculateController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public int addValues(@RequestBody CalculateRequest request) {
        return calculatorService.add(request.getA(), request.getB());
    }
}

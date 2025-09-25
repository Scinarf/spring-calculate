package com.example.demo.controller;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public int addValues(@RequestBody CalculateRequest request) {
        return calculatorService.add(request.getA(), request.getB());
    }

    @GetMapping("/minus")
    public int subtractValues(@RequestBody CalculateRequest request) {
        return calculatorService.minus(request.getA(), request.getB());
    }

    @GetMapping("/multiply")
    public int multiplyValues(@RequestBody CalculateRequest request) {
        return calculatorService.multiply(request.getA(), request.getB());
    }

    @GetMapping("/divide")
    public int divideValues(@RequestBody CalculateRequest request) {
        return calculatorService.divide(request.getA(), request.getB());
    }
}

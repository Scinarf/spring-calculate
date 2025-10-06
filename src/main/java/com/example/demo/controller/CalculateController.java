package com.example.demo.controller;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
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
    public void cal (@RequestBody CalculateRequest request){
        calculatorService.addValues(request);
    }

    @PostMapping("/minus")
    public void subtracting (@RequestBody CalculateRequest request){
        calculatorService.minusValues(request);
    }

    @PostMapping("/multipply")
    public void multiplication (@RequestBody CalculateRequest request){
        calculatorService.multiplyValues(request);
    }

    @PostMapping("/divide")
    public void division (@RequestBody CalculateRequest request){
        calculatorService.divideValues(request);
    }

    @GetMapping("/{id}")
    public CalculateEntity findById(@PathVariable("id") Long id){
        return calculatorService.findById(id);
    }

    @GetMapping("/history")
    public List<CalculateEntity> getAllAnswers(){
        return calculatorService.calculations();
    }
}

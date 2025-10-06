package com.example.demo.service;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CalculatorService {

    CalculateEntity addValues(CalculateRequest cal);

    CalculateEntity minusValues(CalculateRequest cal);

    CalculateEntity multiplyValues(CalculateRequest cal);

    CalculateEntity divideValues(CalculateRequest cal);

    List<CalculateEntity> calculations();

    CalculateEntity findById(Long id);

}

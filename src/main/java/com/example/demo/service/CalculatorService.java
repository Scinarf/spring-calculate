package com.example.demo.service;

import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CalculatorService {

         int add(int a , int b);

         int minus(int a , int b);

         int multiply(int a , int b);

         int divide(int a , int b);

         List<CalculateEntity> calculations();

}

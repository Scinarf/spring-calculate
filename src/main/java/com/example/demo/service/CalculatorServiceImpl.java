package com.example.demo.service;

import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private CalculateRepository calculateRepository;

    public CalculatorServiceImpl(){}

    public CalculatorServiceImpl(CalculateRepository calculateRepository) {
        this.calculateRepository = calculateRepository;
    }

    public int add(int a , int b){
        CalculateEntity c = CalculateEntity.builder()
                .a(a)
                .b(b)
                .result((a+b))
                .action(String.valueOf(CalculateActions.Addition))
                .build();
        answer(c);
        return (a+b);
    }

    public int minus(int a , int b){
        CalculateEntity c = CalculateEntity.builder()
                .a(a)
                .b(b)
                .result((a+b))
                .action(String.valueOf(CalculateActions.Subtraction))
                .build();
        answer(c);
        return (a-b);
    }

    public int multiply(int a , int b){
        CalculateEntity c = CalculateEntity.builder()
                .a(a)
                .b(b)
                .result((a+b))
                .action(String.valueOf(CalculateActions.Multiplication))
                .build();
        answer(c);
        return (a*b);
    }

    public int divide(int a , int b){
        CalculateEntity c = CalculateEntity.builder()
                .a(a)
                .b(b)
                .result((a+b))
                .action(String.valueOf(CalculateActions.Division))
                .build();
        answer(c);
        return (a/b);
    }

    private void answer(CalculateEntity a){

        calculateRepository.save(a);
    }

    public List<CalculateEntity> calculations(){
        return calculateRepository.findAll();
    }
}

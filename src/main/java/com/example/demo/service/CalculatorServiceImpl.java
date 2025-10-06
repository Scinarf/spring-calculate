package com.example.demo.service;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.repository.CalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private CalculateRepository calculateRepository;

    public CalculatorServiceImpl(){}

    @Autowired
    public CalculatorServiceImpl(CalculateRepository calculateRepository) {
        this.calculateRepository = calculateRepository;
    }

    public CalculateEntity addValues (CalculateRequest cal){
        CalculateEntity call = CalculateEntity.builder()
                .a(cal.getA())
                .b(cal.getB())
                .result((cal.getA()+cal.getB()))
                .action(String.valueOf(CalculateActions.Addition))
                .build();
        return calculateRepository.save(call);
    }

    public CalculateEntity minusValues (CalculateRequest cal){
        CalculateEntity call = CalculateEntity.builder()
                .a(cal.getA())
                .b(cal.getB())
                .result((cal.getA()-cal.getB()))
                .action(String.valueOf(CalculateActions.Subtraction))
                .build();
        return calculateRepository.save(call);
    }

    public CalculateEntity multiplyValues (CalculateRequest cal){
        CalculateEntity call = CalculateEntity.builder()
                .a(cal.getA())
                .b(cal.getB())
                .result((cal.getA()*cal.getB()))
                .action(String.valueOf(CalculateActions.Multiplication))
                .build();
        return calculateRepository.save(call);
    }

    public CalculateEntity divideValues (CalculateRequest cal){
        CalculateEntity call = CalculateEntity.builder()
                .a(cal.getA())
                .b(cal.getB())
                .result((cal.getA()/cal.getB()))
                .action(String.valueOf(CalculateActions.Division))
                .build();
        return calculateRepository.save(call);
    }


    public List<CalculateEntity> calculations(){

        return calculateRepository.findAll();
    }

    public CalculateEntity findById(Long id){
        return  calculateRepository.findById(id).get();
    }
}

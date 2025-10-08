package com.example.demo.service;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.mapper.MapToEntity;
import com.example.demo.repository.CalculateRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculatorServiceImplTest {

    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl(Mockito.mock(CalculateRepository.class));

    @Test
    void fivePlusEightShouldEqualThirteen() {
        CalculateRequest calculateRequest = CalculateRequest.builder()
                .a(5)
                .b(8)
                .action(String.valueOf(CalculateActions.Addition))
                .result((5+8))
                .build();
        when(calculatorService.addValues(calculateRequest)).thenReturn( MapToEntity.mapToCalculateEntity(calculateRequest));

        assertEquals(13,calculatorService.addValues(calculateRequest).getResult());
    }

    @Test
    void tenMinusNineShouldEqualsOne() {
        CalculateRequest calculateRequest = CalculateRequest.builder()
                .a(10)
                .b(9)
                .action(String.valueOf(CalculateActions.Subtraction))
                .result((10-9))
                .build();

        when(calculatorService.minusValues(calculateRequest)).thenReturn( MapToEntity.mapToCalculateEntity(calculateRequest));

        assertEquals(1,calculatorService.minusValues(calculateRequest).getResult());
    }

    @Test
    void fourMultipliedByFiveEqualsTwenty() {
        CalculateRequest calculateRequest = CalculateRequest.builder()
                .a(4)
                .b(5)
                .action(String.valueOf(CalculateActions.Multiplication))
                .result((4*5))
                .build();
        when(calculatorService.multiplyValues(calculateRequest)).thenReturn( MapToEntity.mapToCalculateEntity(calculateRequest));

        assertEquals(20,calculatorService.multiplyValues(calculateRequest).getResult());
    }

    @Test
    void hundredDividedByTenEqualsTen() {
        CalculateRequest calculateRequest = CalculateRequest.builder()
                .a(100)
                .b(10)
                .action(String.valueOf(CalculateActions.Subtraction))
                .result((100/10))
                .build();


        when(calculatorService.divideValues(calculateRequest)).thenReturn( MapToEntity.mapToCalculateEntity(calculateRequest));

        assertEquals(10,calculatorService.divideValues(calculateRequest).getResult());
    }

    @Test
    void calculations() {
        List<CalculateEntity> calculateEntityList = new ArrayList<>();
        calculateEntityList.add(CalculateEntity.builder()
                .a(4)
                .b(5)
                .action(String.valueOf(CalculateActions.Multiplication))
                .result((4*5))
                .build());
        calculateEntityList.add(CalculateEntity.builder()
                .a(10)
                .b(9)
                .action(String.valueOf(CalculateActions.Subtraction))
                .result((10-9))
                .build());
        when(calculatorService.calculations()).thenReturn(calculateEntityList);

        assertEquals(calculateEntityList,calculatorService.calculations());
    }
}
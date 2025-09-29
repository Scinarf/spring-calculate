package com.example.demo.service;

import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.repository.CalculateRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl(Mockito.mock(CalculateRepository.class));

    @Test
    void fivePlusEightShouldEqualThirteen() {

        assertEquals(13,calculatorService.add(5,8 ));
    }

    @Test
    void tenMinusNineShouldEqualsOne() {
        assertEquals(1,calculatorService.minus(10,9));
    }

    @Test
    void fourMultipliedByFiveEqualsTwenty() {
        assertEquals(20, calculatorService.multiply(4,5));
    }

    @Test
    void hundredDividedByTenEqualsTen() {
        assertEquals(10,calculatorService.divide(100,10));
    }

    @Test
    void calculations() {
//        List<CalculateEntity> expected = new ArrayList<>();
//        expected.add(new CalculateEntity().builder()
//                        .a(3)
//                        .b(9)
//                        .action(String.valueOf(CalculateActions.Multiplication))
//                        .result(calculatorService.multiply(3,9))
//                .build());
//
//        expected.add(new CalculateEntity().builder()
//                .a(5)
//                .b(26)
//                .action(String.valueOf(CalculateActions.Addition))
//                .result(calculatorService.add(5,26))
//                .build());

        List<CalculateEntity> actual = calculatorService.calculations();

        //assertEquals(expected,actual);
        assertNotNull(actual);
    }
}
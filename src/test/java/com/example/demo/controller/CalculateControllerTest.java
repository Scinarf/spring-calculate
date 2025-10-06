package com.example.demo.controller;

import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.service.CalculatorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CalculateController.class)
class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorServiceImpl calculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addValues() throws Exception{
        CalculateEntity user = new CalculateEntity(1L, 5,10, String.valueOf(CalculateActions.Addition),15);
        when(calculatorService.add(5,10)).thenReturn(15);

//        mockMvc.perform(get("/api/calculate/add"))
//                .andExpect(jsonPath("$.a").value(5))
//                .andExpect(jsonPath("$.b").value(10))
//                .andExpect(jsonPath("$.result").value(15))
//                .andExpect(status().isOk());


//        mockMvc.perform(get("/api/calculate/add"))
//                .param("a",5)
//                .param("b",10)
//                .andExpect(status().isOk());
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.a").value(5))
////                .andExpect(jsonPath("$.b").value(10))
////                .andExpect(jsonPath("$.result").value(15));

    }

    @Test
    void subtractValues() {
    }

    @Test
    void multiplyValues() {
    }

    @Test
    void divideValues() {
    }

    @Test
    void getAllAnswers() {
    }
}
package com.example.demo.controller;

import com.example.demo.entity.CalculateEntity;
import com.example.demo.enums.CalculateActions;
import com.example.demo.mapper.MapToRequest;
import com.example.demo.service.CalculatorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        when(calculatorService.addValues(MapToRequest.mapToRequest(user))).thenReturn(user);

        mockMvc.perform(post("/api/calculate/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void subtractValues() throws Exception {
        CalculateEntity user = new CalculateEntity(1L, 20,10, String.valueOf(CalculateActions.Subtraction),10);
        when(calculatorService.minusValues(MapToRequest.mapToRequest(user))).thenReturn(user);

        mockMvc.perform(post("/api/calculate/minus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void multiplyValues() throws Exception {
        CalculateEntity user = new CalculateEntity(1L, 6,5, String.valueOf(CalculateActions.Addition),30);

        when(calculatorService.multiplyValues(MapToRequest.mapToRequest(user))).thenReturn(user);

        mockMvc.perform(post("/api/calculate/multipply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void divideValues() throws Exception {
        CalculateEntity user = new CalculateEntity(1L, 150,50, String.valueOf(CalculateActions.Addition),3);
        when(calculatorService.divideValues(MapToRequest.mapToRequest(user))).thenReturn(user);

        mockMvc.perform(post("/api/calculate/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void getAllAnswers() throws Exception {
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

        mockMvc.perform(get("/api/calculate/history")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(calculateEntityList)))
                .andExpect(status().isOk());
    }
}
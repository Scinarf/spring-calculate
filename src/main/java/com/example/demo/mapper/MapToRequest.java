package com.example.demo.mapper;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;

public class MapToRequest {

    public static CalculateRequest mapToRequest(CalculateEntity entity){
        return CalculateRequest.builder()
                .a(entity.getA())
                .b(entity.getB())
                .result(entity.getResult())
                .action(entity.getAction())
                .build();
    }
}

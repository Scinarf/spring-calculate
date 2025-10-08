package com.example.demo.mapper;

import com.example.demo.dto.CalculateRequest;
import com.example.demo.entity.CalculateEntity;

public class MapToEntity {
    public static CalculateEntity mapToCalculateEntity(CalculateRequest request){
        return CalculateEntity.builder()
                .a(request.getA())
                .b(request.getB())
                .result(request.getResult())
                .action(request.getAction())
                .build();
    }
}

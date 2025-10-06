package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalculateRequest {
    private int a;
    private int b;
    private String action;
    private int result;
}

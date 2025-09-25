package com.example.demo.repository;

import com.example.demo.entity.CalculateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculateRepository extends JpaRepository<CalculateEntity,Long> {
}

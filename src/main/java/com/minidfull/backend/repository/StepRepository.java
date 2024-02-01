package com.minidfull.backend.repository;

import com.minidfull.backend.entity.Steps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Steps, Long> {
}

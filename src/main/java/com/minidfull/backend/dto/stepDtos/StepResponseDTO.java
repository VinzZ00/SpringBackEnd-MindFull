package com.minidfull.backend.dto.stepDtos;

import com.minidfull.backend.entity.Steps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepResponseDTO {
    private List<Steps> data;
}

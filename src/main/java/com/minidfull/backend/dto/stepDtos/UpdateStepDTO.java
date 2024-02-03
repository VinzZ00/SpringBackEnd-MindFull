package com.minidfull.backend.dto.stepDtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStepDTO {

    @NotBlank private Long stepId;
    @NotBlank @Size(max = 255) private String motivation;

    @NotBlank @Size(max = 255) private String stepDescription;
    @NotBlank private Time dailyTime;
}

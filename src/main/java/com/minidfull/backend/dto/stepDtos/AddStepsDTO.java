package com.minidfull.backend.dto.stepDtos;

import com.minidfull.backend.entity.Goals;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddStepsDTO {

    @NotBlank @Size(max = 255)
    private String stepDescription;

    @NotBlank @Size(max = 255)
    private String motivation;

    Time dailyTime;

    // Parent DTO
    private Goals parent;

}

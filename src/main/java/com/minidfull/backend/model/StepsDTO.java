package com.minidfull.backend.model;

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
public class StepsDTO {

    Time dailyTime;

    @NotBlank @Size(max = 255)
    private String motivation;

    // Parent DTO
    private Goals parent;

}

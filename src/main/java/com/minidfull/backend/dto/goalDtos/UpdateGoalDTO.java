package com.minidfull.backend.dto.goalDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGoalDTO {

    @NotBlank
    private Long goalId;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank @Size(max = 255)
    private String goalIndicator;

    private Date timeBound;
    private Date dateCreatedAt;

    @NotBlank
    private int priority;
}

package com.minidfull.backend.dto.goalDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteGoalsDTO {
    @NotBlank
    private Long[] goalIds;
}

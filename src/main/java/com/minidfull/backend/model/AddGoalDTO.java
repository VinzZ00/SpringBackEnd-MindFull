package com.minidfull.backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddGoalDTO {

    @NotBlank @Size(max = 255)
    private String name;

    @NotBlank @Size(max = 255)
    private String goalIndicator;

    private Date timeBound;
    private Date dateCreatedAt;

    @NotBlank @Size(max = 255)
    private String reason;

}

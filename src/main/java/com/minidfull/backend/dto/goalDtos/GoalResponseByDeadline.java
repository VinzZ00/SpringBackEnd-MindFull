package com.minidfull.backend.dto.goalDtos;

import com.minidfull.backend.entity.Steps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoalResponseByDeadline {

    private Long goalId;
    private String name;
    private String goalIndicator;
    private Date dateCreatedAt;
    private int priority;
    private List<Steps> steps;

}

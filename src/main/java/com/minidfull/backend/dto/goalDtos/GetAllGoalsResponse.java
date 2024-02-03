package com.minidfull.backend.dto.goalDtos;

import com.minidfull.backend.entity.Goals;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllGoalsResponse {
    private List<Goals> datas;
}

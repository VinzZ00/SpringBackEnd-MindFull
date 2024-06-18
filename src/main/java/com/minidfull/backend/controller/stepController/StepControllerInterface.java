package com.minidfull.backend.controller.stepController;

import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.dto.stepDtos.AddStepsDTO;
import com.minidfull.backend.dto.stepDtos.DeleteStepsDTO;
import com.minidfull.backend.dto.stepDtos.StepResponseDTO;
import com.minidfull.backend.dto.stepDtos.UpdateStepDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface StepControllerInterface {
    WebResponse<String> addStep(@RequestBody AddStepsDTO request);
    WebResponse<String> updateStep(UpdateStepDTO request);
    WebResponse<String> deleteStep(DeleteStepsDTO request);
    StepResponseDTO getStepByGoal(Long goalId);
}

package com.minidfull.backend.controller.stepController;

import com.minidfull.backend.dto.WebResponse;
import com.minidfull.backend.dto.StepsDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface StepControllerInterface {
    WebResponse<String> addStep(@RequestBody StepsDTO request);
}

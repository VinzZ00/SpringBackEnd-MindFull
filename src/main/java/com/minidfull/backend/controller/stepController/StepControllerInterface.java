package com.minidfull.backend.controller.stepController;

import com.minidfull.backend.model.StepsDTO;
import com.minidfull.backend.model.WebResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface StepControllerInterface {
    WebResponse<String> addStep(@RequestBody StepsDTO request);
}

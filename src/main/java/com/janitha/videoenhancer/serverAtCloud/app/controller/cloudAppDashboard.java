package com.janitha.videoenhancer.serverAtCloud.app.controller;

import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletInfo;
import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class cloudAppDashboard {

    @PostMapping("/getAvailableClouldets")
    public cloudletInfo involkePlugIn(@RequestBody cloudletRequest request) throws IOException, InterruptedException {

        return new cloudletInfo();
    }

}

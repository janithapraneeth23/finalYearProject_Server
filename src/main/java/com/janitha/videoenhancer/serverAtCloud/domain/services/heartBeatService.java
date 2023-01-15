package com.janitha.videoenhancer.serverAtCloud.domain.services;

import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class heartBeatService {

    @Autowired
    CloudletManager cloudletManager;
    public heartBeatService()
    {
        /*cloudletInfo tmp = new cloudletInfo("Nemo", "192.168.8.131", "8084");
        cloudletInfo tmp1 = new cloudletInfo("Toby", "192.168.8.131", "8084");
        cloudletInfo tmp2 = new cloudletInfo("Kitty", "192.168.8.131", "8084");
        cloudletManager.addCloudlet(tmp);
        cloudletManager.addCloudlet(tmp1);
        cloudletManager.addCloudlet(tmp2);*/
    }


}

package com.janitha.videoenhancer.serverAtCloud.app.controller;

import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletInfo;
import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletRequest;
import com.janitha.videoenhancer.serverAtCloud.domain.services.CloudletManager;
import com.janitha.videoenhancer.serverAtCloud.domain.services.heartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

@RestController
public class cloudAppDashboard {

    @Autowired
    CloudletManager cloudletManager;

    /*@PostMapping("/getAvailableClouldets_OLD")
    public cloudletInfo involkePlugIn(@RequestBody cloudletRequest request) throws IOException, InterruptedException {

        return new cloudletInfo();
    }*/

    @GetMapping("/getAvailableClouldets")
    public String getAvailableCloudlets() throws IOException, InterruptedException {
        List<cloudletInfo> cloudlets = cloudletManager.getCloudletList();

        String strCloudletes = "";
        if(cloudlets == null) return "No Cloudlets Connected!";
        for(cloudletInfo clodulet : cloudlets){
            strCloudletes += clodulet.getName() + "<br>";
        }
        //System.out.println(strCloudletes);
        return strCloudletes;

    }

    @GetMapping("/getNearbyClouldet")
    public String getNearbyClouldet() throws IOException, InterruptedException {
        cloudletInfo tmp = cloudletManager.getNearbyCloudlet();
        String cloudletIP = tmp.getIp();
        String cloudletPort = tmp.getPort();
        return cloudletIP + ":" + cloudletPort;

    }
}

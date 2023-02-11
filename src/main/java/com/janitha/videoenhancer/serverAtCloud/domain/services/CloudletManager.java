package com.janitha.videoenhancer.serverAtCloud.domain.services;

import com.janitha.videoenhancer.serverAtCloud.app.models.cloudletInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CloudletManager {
    Map<String, cloudletInfo> cloudletIptoCloduletInfo;


    public CloudletManager() {
        this.cloudletIptoCloduletInfo =   new HashMap<String, cloudletInfo>();
        /*cloudletInfo tmp = new cloudletInfo("Nemo", "192.168.8.131", "8084");
        cloudletInfo tmp1 = new cloudletInfo("Toby", "192.168.8.131", "8085");
        cloudletInfo tmp2 = new cloudletInfo("Kitty", "192.168.8.131", "8086");
        this.addCloudlet(tmp);
        this.addCloudlet(tmp1);
        this.addCloudlet(tmp2);*/
    }

    public void addCloudlet(cloudletInfo cloudlet)
    {
        //System.out.println(cloudlet.getIp() + ":" +cloudlet.getPort());
        cloudletIptoCloduletInfo.put(cloudlet.getIp() + ":" +cloudlet.getPort(), cloudlet);

    }

    @Value("${cloudlet.ip}")
    private String cloudletIP;

    @Value("${cloudlet.port}")
    private String cloudletport;

    public cloudletInfo getNearbyCloudlet()
    {
        /*cloudletInfo tmp = new cloudletInfo("Dora", cloudletIP, cloudletport);
        return tmp;*/

        for (cloudletInfo tmpCloudInfo : cloudletIptoCloduletInfo.values())
        {
            //System.out.println(tmpCloudInfo.getName());
            return tmpCloudInfo;

        }
        return null;
    }

    public void unregisterCloudlet(String ip, String port)
    {
        String index = ip + ":" + port;
        cloudletIptoCloduletInfo.remove(index);
    }

    public List getCloudletList(){
        List<cloudletInfo> tmpList = new ArrayList<cloudletInfo>();
        for (cloudletInfo tmpCloudInfo : cloudletIptoCloduletInfo.values())
        {
            //System.out.println(tmpCloudInfo.getName());
            tmpList.add(tmpCloudInfo);

        }
        return tmpList;
    }

}

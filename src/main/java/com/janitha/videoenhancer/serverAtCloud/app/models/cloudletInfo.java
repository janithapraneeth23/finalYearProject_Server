package com.janitha.videoenhancer.serverAtCloud.app.models;

public class cloudletInfo {

    String ip;
    String port;
    String name;
    public cloudletInfo(String name, String ip, String port) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }


    public String getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
}

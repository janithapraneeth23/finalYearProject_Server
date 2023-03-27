package com.janitha.videoenhancer.serverAtCloud.app.models;

public class cloudletInfo {

    String ip;
    String externalIp;
    String port;
    String name;
    public cloudletInfo(String name, String ip, String externalIp, String port) {
        this.ip = ip;
        this.externalIp = externalIp;
        this.port = port;
        this.name = name;
    }
    public String getExternalIp() {
        return externalIp;
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

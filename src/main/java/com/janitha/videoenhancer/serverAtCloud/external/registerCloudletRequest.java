package com.janitha.videoenhancer.serverAtCloud.external;

public class registerCloudletRequest {
    String ip;
    String port;

    String externalIp;
    String name;
    String location;

    public registerCloudletRequest(String ip, String port, String externalIp, String name, String location) {
        this.ip = ip;
        this.port = port;
        this.externalIp = externalIp;
        this.name = name;
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    public String getExternalIp() {
        return externalIp;
    }

    public void setExternalIp(String externalIp) {
        this.externalIp = externalIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.gjk.view;

/**
 * @Author: liyang117
 * @Date: 2018/5/15 19:53
 * @Description:
 */
public class AddScreenRequest {
    private String macAddress;
    private Integer fresh;
    private Integer port;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getFresh() {
        return fresh;
    }

    public void setFresh(Integer fresh) {
        this.fresh = fresh;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}

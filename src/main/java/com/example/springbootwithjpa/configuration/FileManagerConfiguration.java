package com.example.springbootwithjpa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author TangHuaJie
 * @Date Created in 2020/10/22 18:01
 */

@Configuration
public class FileManagerConfiguration {

    @Value("${file.saveLinuxPath}")
    private String saveLinuxPath;

    @Value("${file.saveWindowsPath}")
    private String saveWindowsPath;

    @Value("${wx.appid}")
    private String appId;

    @Value("${wx.appsecret}")
    private String appsecret;

    public String getSaveLinuxPath() {
        return saveLinuxPath;
    }

    public void setSaveLinuxPath(String saveLinuxPath) {
        this.saveLinuxPath = saveLinuxPath;
    }

    public String getSaveWindowsPath() {
        return saveWindowsPath;
    }

    public void setSaveWindowsPath(String saveWindowsPath) {
        this.saveWindowsPath = saveWindowsPath;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}

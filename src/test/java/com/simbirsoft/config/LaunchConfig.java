package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${stand}.properties"})
public interface LaunchConfig extends Config {

    @Config.Key("browser")
    String getBrowser();

    @Config.Key("size")
    String getSize();

    @Config.Key("version")
    String getVersion();


    @Config.Key("isRemote")
    boolean isRemote();

    @Config.Key("remoteURL")
    String getRemoteURL();

    @Config.Key("login")
    String remoteLogin();

    @Config.Key("password")
    String remotePassword();
}

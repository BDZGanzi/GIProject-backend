package com.wallfacer5.giproject.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties("genshin.bbsheader")
@Setter
@Getter
@ToString
public class BBSHeaderConfig {
    private String ds;
    private String cookies;
    private String xRpcClientType;
    private String xRpcAppVersion;
    private String xRequestedWith;
    private String secFetchSite;
    private String secFetchMode;
    private String secFetchDest;
    private String referer;
    private String acceptEncoding;
    private String acceptLanguage;
    private String origin;
    private String accept;
    private String userAgent;
}

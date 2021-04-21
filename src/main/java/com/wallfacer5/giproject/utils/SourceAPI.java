package com.wallfacer5.giproject.utils;

import java.io.IOException;

import com.wallfacer5.giproject.entity.BBSHeaderConfig;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SourceAPI {
    private static Logger log = LoggerFactory.getLogger(SourceAPI.class);

    @Autowired
    BBSHeaderConfig headers;

    public String getPlayerInfo(String uid){
        String url = GenshinImpact.getPlayerUrlByUid(uid);
        try {
            return getConnection(url, null).get().body().text();
        } catch (IOException e) {
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    public String getCharacterInfo(String reqBody){
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/character";
        try {
            return getConnection(url, reqBody).post().body().text();
        } catch (IOException e) {
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    public String getAbyssInfo(String uid, int scheduleType){
        String url = GenshinImpact.getSpiralAbyssUrlByUid(uid, scheduleType);
        try {
            return getConnection(url, null).get().body().text();
        } catch (IOException e){
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    private Connection getConnection(String url, String reqBody) {
        Connection conn = Jsoup.connect(url)
        .header("DS", GenshinImpact.getDS())
        .header("x-rpc-app_version", GenshinImpact.getVersion())
        .header("User-Agent",headers.getUserAgent())
        .header("Accept", headers.getAccept())
        .header("x-rpc-client_type", headers.getXRpcClientType())
        .header("Origin", headers.getOrigin())
        .header("X-Requested-With", headers.getXRequestedWith())
        .header("Sec-Fetch-Site", headers.getSecFetchSite())
        .header("Sec-Fetch-Mode", headers.getSecFetchMode())
        .header("Sec-Fetch-Dest", headers.getSecFetchDest())
        .header("Referer", headers.getReferer())
        .header("Accept-Encoding", headers.getAcceptEncoding())
        .header("Accept-Language", headers.getAcceptLanguage())
        .cookie("Cookie", headers.getCookies())
        .ignoreContentType(true);
        // 部分查询需要转成 POST 请求
        if(!"".equals(reqBody) && reqBody != null){
            log.warn("POST Request. Body:[{}]", reqBody);
            conn = conn.requestBody(reqBody).method(Method.POST);
        }
        return conn;
    }
}

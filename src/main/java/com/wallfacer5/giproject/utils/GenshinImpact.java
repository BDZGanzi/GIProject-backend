package com.wallfacer5.giproject.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Random;

import com.wallfacer5.giproject.entity.BBSHeaderConfig;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

public class GenshinImpact {
    static Logger log = LoggerFactory.getLogger(GenshinImpact.class);

    public static String getPlayerInfoByUid(String uid, BBSHeaderConfig headerConfig){
        String url = getPlayerUrlByUid(uid);
        Connection conn = getConnection(url, headerConfig, null);
        try {
            return conn.get().body().text();
        } catch (IOException e) {
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    public static String getSpiralAbyssInfoByUid(String uid, int scheduleType, BBSHeaderConfig headerConfig) {
        String url = getSpiralAbyssUrlByUid(uid, scheduleType);
        try {
            return getConnection(url, headerConfig, null).get().body().text();
        } catch (IOException e){
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    public static String getCharacterInfo(BBSHeaderConfig headerConfig, String reqBody){
        // POST请求，附带json{"character_ids":[角色id,角色id,角色id,..........],"role_id":"游戏ID","server":"所在服"}
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/character";
        Connection conn = getConnection(url, headerConfig, reqBody);
        try {
            return conn.post().body().text();
        } catch (IOException e) {
            log.warn("Exception:[{}]", e.getMessage());
        }
        return null;
    }

    private static Connection getConnection(String url, BBSHeaderConfig headerConfig, String reqBody) {
        Connection conn = Jsoup.connect(url)
        .header("DS", getDS())
        .header("x-rpc-app_version", getVersion())
        .header("User-Agent",headerConfig.getUserAgent())
        .header("Accept", headerConfig.getAccept())
        .header("x-rpc-client_type", headerConfig.getXRpcClientType())
        .header("Origin", headerConfig.getOrigin())
        .header("X-Requested-With", headerConfig.getXRequestedWith())
        .header("Sec-Fetch-Site", headerConfig.getSecFetchSite())
        .header("Sec-Fetch-Mode", headerConfig.getSecFetchMode())
        .header("Sec-Fetch-Dest", headerConfig.getSecFetchDest())
        .header("Referer", headerConfig.getReferer())
        .header("Accept-Encoding", headerConfig.getAcceptEncoding())
        .header("Accept-Language", headerConfig.getAcceptLanguage())
        .cookie("Cookie", headerConfig.getCookies())
        .ignoreContentType(true);
        if(!"".equals(reqBody) && reqBody != null){
            log.warn("POST Request. Body:[{}]", reqBody);
            conn = conn.requestBody(reqBody).method(Method.POST);
        }
        return conn;
    }

    private static String getPlayerUrlByUid(String uid) {
        String server = getServerByUid(uid);
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/index" + "?server=" + server + "&role_id="
                + uid;
        log.info("Player Info url:[{}]", url);
        return url;
    }

    private static String getSpiralAbyssUrlByUid(String uid, int scheduleType) {
        String server = getServerByUid(uid);
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/spiralAbyss" + "?schedule_type="
                + scheduleType + "&server=" + server + "&role_id=" + uid;
        // String url = String.format("https://api-takumi.mihoyo.com/game_record/genshin/api/spiralAbyss?schedule_type={}&server={}&role_id={}",
        //         scheduleType, server, uid);
        log.info("Abyss Info url:[{}]", url);
        return url;
    }

    private static String getDataWithJsoup(String url, String cookies) {
        try {
            return Jsoup.connect(url).header("Accept", "application/json, text/plain, */*").header("DS", getDS())
                    .header("x-rpc-app_version", getVersion())
                    .header("User-Agent",
                            "Mozilla/5.0 (Linux; Android 9; ONEPLUS A5000 Build/PKQ1.180716.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/85.0.4183.127 Mobile Safari/537.36 miHoYoBBS/2.5.1")
                    .header("x-rpc-client_type", "5").header("Origin", "https://webstatic.mihoyo.com")
                    .header("X-Requested-With", "com.mihoyo.hyperion").header("Sec-Fetch-Site", "same-site")
                    .header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Dest", "empty")
                    .header("Referer", "https://webstatic.mihoyo.com/").header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7").cookie("Cookie", cookies)
                    .ignoreContentType(true).get().body().text();
        } catch (IOException e) {
            log.info("IOException message:[{}]", e.getMessage());
        }
        return null;
    }

    private static String getDS() {
        // String md5Version = DigestUtils.md5DigestAsHex(getVersion().getBytes());
        String md5Version = "cx2y9z9a29tfqvr1qsq6c7yz99b5jsqt";
        String t = Long.toString(System.currentTimeMillis() / 1000);
        String r = MyRandom(6); // Todo 有没有其他实现？
        String c = DigestUtils.md5DigestAsHex(("salt=" + md5Version + "&t=" + t + "&r=" + r).getBytes());
        log.info("fun 1----version[{}]t[{}]c[{}]", md5Version, t, c);
        return t + "," + r + "," + c;
    }

    private static String getVersion() {
        return "2.2.1";
    }

    private static String MyRandom(int len) {
        Random rd = new Random();
        char[] x = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();// ABCDEFGHIJKLMNOPQRSTUVWXYZ
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = x[rd.nextInt(x.length)];
        }
        return new String(str);
    }

    public static String getServerByUid(String uid) {
        char first = uid.charAt(0);
        String server = null;
        switch (first) {
        case '1':
            log.info("in case:[{}]", "cn_gf01");
            server = "cn_gf01";
            break;
        case '6':
            log.info("in case:[{}]", "na");
            server = "na";
            break;
        default:
            log.warn("wrong uid:[{}]", uid);
            throw new IllegalArgumentException("Wrong uid");
        }
        return server;
    }


    public static void main(String[] args) throws URISyntaxException, IOException {
        String cookies = "UM_distinctid=1785795bf2678-09bd851147d029-2542793a-49a10-1785795bf271b3; _MHYUUID=94dd314e-fd51-4c24-8a97-7e8416d5a24f; ltoken=UsSzYPwOZSSrS4FILImXL4vgp7ntMCgSKTmHt8AP; ltuid=239925102; account_id=239925102; login_ticket=T3eGQbIR6N0LgrIsFWr5KYUNUJT91rgbaRYWR5yY; cookie_token=kLl1Z5WcwAOsrKeeqR3hFBgRQjZ5QrfK601A3gL1";
        String url = getPlayerUrlByUid("143820223");
        String data = getDataWithJsoup(url, cookies);
        try (Writer writer = new FileWriter(new File("data.json"))) {
            writer.write(data);
        }
    }
}

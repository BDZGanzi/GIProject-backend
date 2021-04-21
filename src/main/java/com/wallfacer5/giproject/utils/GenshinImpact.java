package com.wallfacer5.giproject.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

public class GenshinImpact {
    static Logger log = LoggerFactory.getLogger(GenshinImpact.class);

    private static String BASE_URL = "https://api-takumi.mihoyo.com/game_record/genshin/api/";

    public static String getPlayerUrlByUid(String uid) {
        String server = getServerByUid(uid);
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/index" + "?server=" + server + "&role_id="
                + uid;
        log.info("Player Info url:[{}]", url);
        return url;
    }

    public static String getSpiralAbyssUrlByUid(String uid, int scheduleType) {
        String server = getServerByUid(uid);
        String url = "https://api-takumi.mihoyo.com/game_record/genshin/api/spiralAbyss" + "?schedule_type="
                + scheduleType + "&server=" + server + "&role_id=" + uid;
        log.info("Abyss Info url:[{}]", url);
        return url;
    }

    public static String getDS() {
        // String md5Version = DigestUtils.md5DigestAsHex(getVersion().getBytes());
        String md5Version = "cx2y9z9a29tfqvr1qsq6c7yz99b5jsqt";
        String t = Long.toString(System.currentTimeMillis() / 1000);
        String r = MyRandom(6); // Todo 有没有其他实现？
        String c = DigestUtils.md5DigestAsHex(("salt=" + md5Version + "&t=" + t + "&r=" + r).getBytes());
        log.info("fun 1----version[{}]t[{}]c[{}]", md5Version, t, c);
        return t + "," + r + "," + c;
    }

    public static String getVersion() {
        return "2.2.1";
    }

    public static String MyRandom(int len) {
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
            server = "cn_gf01";
            break;
        case '6':
            server = "na";
            break;
        default:
            log.warn("wrong uid:[{}]", uid);
            throw new IllegalArgumentException("Wrong uid");
        }
        return server;
    }

}

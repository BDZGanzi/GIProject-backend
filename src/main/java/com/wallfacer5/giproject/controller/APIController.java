package com.wallfacer5.giproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wallfacer5.giproject.entity.Player;
import com.wallfacer5.giproject.service.CharacterService;
import com.wallfacer5.giproject.service.PlayerService;
import com.wallfacer5.giproject.service.SpiralAbyssService;
import com.wallfacer5.giproject.utils.GenshinImpact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class APIController {
    @Autowired
    PlayerService playerService;

    @Autowired
    SpiralAbyssService spiralAbyssService;

    @Autowired
    CharacterService characterService;

    @GetMapping("/player/{uid}")
    public String getPlayerInfo(@PathVariable("uid") String uid){
        return playerService.getPlayerInfoByUid(uid);
    }

    @GetMapping("/player2/{uid}")
    public Player getPlayerInfo(@PathVariable("uid") Long uid){
        return playerService.getPlayerInfoByUid(uid);
    }

    @GetMapping("abyss/{uid}/{type}")
    public String getAbyssInfo(@PathVariable("uid") String uid, @PathVariable("type") int type){
        return spiralAbyssService.getSpiralAbyssInfoByUid(uid, type);
    }

    @GetMapping("characters/{uid}")
    public String getCharacterInfo(@PathVariable("uid") String uid) {
        JSONObject json = JSONObject.parseObject(getPlayerInfo(uid));
        JSONArray charactersArray = json.getJSONObject("data").getJSONArray("avatars");
        List<String> ids = new ArrayList<>();
        charactersArray.forEach(character -> {
            ids.add(((JSONObject)character).getString("id"));
        });
        String reqBody = generateReqBody(ids, uid);
        return characterService.getCharacterInfo(reqBody);
    }

    private String generateReqBody(List<String> ids, String uid){
        String server = GenshinImpact.getServerByUid(uid);
        JSONObject json = new JSONObject();
        json.put("server", server);
        json.put("role_id", uid);
        json.put("character_ids", ids);
        return json.toJSONString();
    }
}

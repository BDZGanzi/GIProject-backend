package com.wallfacer5.giproject.controller;

import com.wallfacer5.giproject.service.PlayerService;
import com.wallfacer5.giproject.service.SpiralAbyssService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    PlayerService playerService;

    @Autowired
    SpiralAbyssService spiralAbyssService;

    @GetMapping("/player/{uid}")
    public String getPlayerInfo(@PathVariable("uid") String uid){
        return playerService.getPlayerInfoByUid(uid);
    }

    @GetMapping("abyss/{uid}/{type}")
    public String getAbyssInfo(@PathVariable("uid") String uid, @PathVariable("type") int type){
        return spiralAbyssService.getSpiralAbyssInfoByUid(uid, type);
    }
}

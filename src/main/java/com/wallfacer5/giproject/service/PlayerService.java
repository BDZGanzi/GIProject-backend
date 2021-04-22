package com.wallfacer5.giproject.service;

import com.wallfacer5.giproject.entity.Player;
import com.wallfacer5.giproject.mapper.PlayerMapper;
import com.wallfacer5.giproject.utils.SourceAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    SourceAPI sourceAPI;

    @Autowired
    PlayerMapper playerMapper;

    public String getPlayerInfoByUid(String uid){
        return sourceAPI.getPlayerInfo(uid);
    }

    public Player getPlayerInfoByUid(Long uid){
        return playerMapper.selectPlayerByUid(uid);
    }
}

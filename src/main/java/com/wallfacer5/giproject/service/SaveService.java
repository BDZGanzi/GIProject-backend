package com.wallfacer5.giproject.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallfacer5.giproject.entity.Avatar;
import com.wallfacer5.giproject.entity.Player;
import com.wallfacer5.giproject.entity.Stat;
import com.wallfacer5.giproject.mapper.OwnedAvatarMapper;
import com.wallfacer5.giproject.mapper.PlayerMapper;
import com.wallfacer5.giproject.mapper.StatMapper;
import com.wallfacer5.giproject.utils.SourceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SaveService {
    @Autowired
    SourceAPI sourceAPI;

    @Autowired
    PlayerMapper playerMapper;

    @Autowired
    OwnedAvatarMapper ownedAvatarMapper;

    @Autowired
    StatMapper statMapper;

    @Transactional
    public Player addPlayerInfo(String uid) throws JsonMappingException, JsonProcessingException{
        String data = sourceAPI.getPlayerInfo(uid);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JsonNode statsNode = mapper.readTree(data).get("data").get("stats");
        Stat stats = mapper.treeToValue(statsNode, Stat.class);
        stats.setPlayerId(Long.parseLong(uid));
        statMapper.insert(stats);

        List<Avatar> avatars = new ArrayList<>();
        JsonNode avatarsNode = mapper.readTree(data).get("data").get("avatars");
        if(avatarsNode.isArray()){
            avatarsNode.forEach(avatar -> {
                try {
                    avatars.add(mapper.treeToValue(avatar, Avatar.class));
                } catch (JsonProcessingException e) {
                    log.warn("Exception:[{}]", e.getMessage());
                }
            });
            avatars.forEach(avatar -> {
                avatar.setPlayerId(Long.parseLong(uid));
                ownedAvatarMapper.insert(avatar);
            });
        }

        Player player = new Player(Long.parseLong(uid), null, stats, avatars);
        playerMapper.insert(player);
        
        return null;
    }
}

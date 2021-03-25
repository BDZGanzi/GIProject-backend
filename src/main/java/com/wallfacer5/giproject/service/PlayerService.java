package com.wallfacer5.giproject.service;

import com.wallfacer5.giproject.entity.BBSHeaderConfig;
import com.wallfacer5.giproject.utils.GenshinImpact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    BBSHeaderConfig headerConfig;

    public String getPlayerInfoByUid(String uid){
        return GenshinImpact.getPlayerInfoByUid(uid, headerConfig);
    }
}

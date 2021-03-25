package com.wallfacer5.giproject.service;

import com.wallfacer5.giproject.entity.BBSHeaderConfig;
import com.wallfacer5.giproject.utils.GenshinImpact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import lombok.extern.slf4j.Slf4j;

@Component
// @Slf4j
public class CharacterService {
    @Autowired
    BBSHeaderConfig headerConfig;

    public String getCharacterInfo(String reqBody){
        return GenshinImpact.getCharacterInfo(headerConfig, reqBody);
    }
}

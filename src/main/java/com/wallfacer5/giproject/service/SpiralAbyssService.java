package com.wallfacer5.giproject.service;

import com.wallfacer5.giproject.entity.BBSHeaderConfig;
import com.wallfacer5.giproject.utils.GenshinImpact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpiralAbyssService {
    @Autowired
    BBSHeaderConfig headerConfig;

    public String getSpiralAbyssInfoByUid(String uid, int scheduleType){
        return GenshinImpact.getSpiralAbyssInfoByUid(uid, scheduleType, headerConfig);
    }
}

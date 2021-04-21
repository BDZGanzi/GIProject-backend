package com.wallfacer5.giproject.service;

import com.wallfacer5.giproject.utils.SourceAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpiralAbyssService {
    @Autowired
    SourceAPI sourceAPI;

    public String getSpiralAbyssInfoByUid(String uid, int scheduleType){
        return sourceAPI.getAbyssInfo(uid, scheduleType);
        // return GenshinImpact.getSpiralAbyssInfoByUid(uid, scheduleType, headerConfig);
    }
}

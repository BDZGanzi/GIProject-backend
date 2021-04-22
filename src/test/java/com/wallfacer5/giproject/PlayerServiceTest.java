package com.wallfacer5.giproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wallfacer5.giproject.service.SaveService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerServiceTest {
    @Autowired
    SaveService saveService;

    @Test
    void addPlayerInfo(){
        try {
            saveService.addPlayerInfo("143820223");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

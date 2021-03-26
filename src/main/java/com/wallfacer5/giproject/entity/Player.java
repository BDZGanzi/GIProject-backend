package com.wallfacer5.giproject.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    private Long uid;
    private List<Long> characterIds;
    private Stats stats;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public
    static class Stats {
        Integer activeDayNumber;
        Integer achievementNumber;
        Integer winRate;
        Integer anemoculusNumber;
        Integer geoculusNumber;
        Integer avatarNumber;
        Integer wayPointNumber;
        Integer domainNumber;
        String spiralAbyss;
        Integer preciousChestNumber;
        Integer luxuriousChestNumber;
        Integer exquisiteChestNumber;
        Integer commonChestNumber;
    }

    // public static void main(String[] args) {
    //     // Player player = new Player((long) 11111, new ArrayList<Long>(), new
    //     // Player.Stats(activeDayNumber, achievmentNumber, winRate, anemoculusNumber,
    //     // geoculusNumber, avaterNumber, wayPointNumber, domainNumber, spiralAbyss,
    //     // preciousChestNumber, luxuriousChestNumber, exquisiteChestNumber,
    //     // commonChestNumber));
    // }
}

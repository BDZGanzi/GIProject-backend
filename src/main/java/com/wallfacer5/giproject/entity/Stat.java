package com.wallfacer5.giproject.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Stat {
    
    Long playerId;
    @JsonAlias("active_day_number")
    Integer activeDayNumber;
    @JsonAlias("achievement_number")
    Integer achievementNumber;
    @JsonAlias("win_rate")
    Integer winRate;
    @JsonAlias("anemoculus_number")
    Integer anemoculusNumber;
    @JsonAlias("geoculus_number")
    Integer geoculusNumber;
    @JsonAlias("avatar_number")
    Integer avatarNumber;
    @JsonAlias("way_point_number")
    Integer wayPointNumber;
    @JsonAlias("domain_number")
    Integer domainNumber;
    @JsonAlias("precious_chest_number")
    Integer preciousChestNumber;
    @JsonAlias("luxurious_chest_number")
    Integer luxuriousChestNumber;
    @JsonAlias("exquisite_chest_number")
    Integer exquisiteChestNumber;
    @JsonAlias("common_chest_number")
    Integer commonChestNumber;
    @JsonAlias("spiral_abyss")
    String spiralAbyss;

}

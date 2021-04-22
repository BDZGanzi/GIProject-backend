package com.wallfacer5.giproject.mapper;

import com.wallfacer5.giproject.entity.Stat;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

// painful!!
public interface StatMapper {
    @Select("SELECT * FROM tb_stat WHERE player_id = #{uid}")
    @Results(id = "statMap", value =  { 
        @Result(column = "player_id", property = "playerId", id = true),
        @Result(column = "active_day", property = "activeDayNumber"),
        @Result(column = "achievement", property = "achievementNumber"), 
        @Result(column = "win_rate", property = "winRate"),
        @Result(column = "anemoculus", property = "anemoculusNumber"), 
        @Result(column = "geoculus", property = "geoculusNumber"),
        @Result(column = "avatar", property = "avatarNumber"), 
        @Result(column = "way_point", property = "wayPointNumber"),
        @Result(column = "domain", property = "domainNumber"),
        @Result(column = "spiral_abyss", property = "spiralAbyss"), 
        @Result(column = "precious_chest", property = "preciousChestNumber"),
        @Result(column = "luxurious_chest", property = "luxuriousChestNumber"),
        @Result(column = "exquisite_chest", property = "exquisiteChestNumber"),
        @Result(column = "common_chest", property = "commonChestNumber")
        })
    Stat getStatsByUid(Long uid);

    @Insert("INSERT INTO tb_stat (player_id, active_day, achievement, "+
        "win_rate, anemoculus, geoculus, avatar, way_point, domain, spiral_abyss, "+
        "precious_chest, luxurious_chest, exquisite_chest, common_chest) "+
        "VALUES (#{playerId}, #{activeDayNumber},#{achievementNumber},#{winRate},#{anemoculusNumber},#{geoculusNumber},"+
        "#{avatarNumber},#{wayPointNumber},#{domainNumber},#{spiralAbyss},#{preciousChestNumber},#{luxuriousChestNumber},#{exquisiteChestNumber},#{commonChestNumber})")
    @ResultMap("statMap")
    void insert(Stat stat);
}

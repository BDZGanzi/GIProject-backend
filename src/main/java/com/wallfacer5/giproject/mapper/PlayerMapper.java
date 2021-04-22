package com.wallfacer5.giproject.mapper;

import java.util.List;

import com.wallfacer5.giproject.entity.Player;
import com.wallfacer5.giproject.entity.Stat;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PlayerMapper {
    @Insert("INSERT INTO tb_player (player_id, username) VALUES (#{player.playerId}, #{player.username})")
    void insert(@Param("player") Player player);

    @Select("SELECT * FROM tb_player WHERE player_id = #{uid}")
    @Results(value = { @Result(column = "player_id", property = "playerId"),
            @Result(column = "username", property = "username"),
            @Result(column = "player_id", property = "avatars", javaType = List.class, many = @Many(select = "com.wallfacer5.giproject.mapper.OwnedAvatarMapper.getAvatarsByUid")),
            @Result(column = "player_id", property = "stats", javaType = Stat.class, one = @One(select = "com.wallfacer5.giproject.mapper.StatMapper.getStatsByUid")) })
    Player selectPlayerByUid(Long uid);
}

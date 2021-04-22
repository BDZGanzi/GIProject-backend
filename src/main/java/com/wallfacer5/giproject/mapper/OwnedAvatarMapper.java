package com.wallfacer5.giproject.mapper;

import java.util.List;

import com.wallfacer5.giproject.entity.Avatar;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OwnedAvatarMapper {
    @Select("SELECT * FROM tb_owned_avatar WHERE player_id = #{uid}")
    @Results({
        @Result(column = "avatar_id", property = "avatarId")
    })
    List<Avatar> getAvatarsByUid(Long uid);

    @Insert("INSERT INTO tb_owned_avatar "+
    "(player_id, avatar_id, fetter, level, name, element, image, rarity) "+
    "VALUES "+
    "(#{playerId},#{avatarId},#{fetter},#{level},#{name},#{element},#{image},#{rarity})")
    void insert(Avatar avatar);
}

package com.wallfacer5.giproject.mapper;

import com.wallfacer5.giproject.entity.Avatar;

import org.apache.ibatis.annotations.Select;

public interface AvatarMapper {

    @Select("SELECT * FROM tb_avatar WHERE avatar_id = #{avatarId}")
    Avatar getAvatarById(Long avatarId);
}

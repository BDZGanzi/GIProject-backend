package com.wallfacer5.giproject.entity;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Avatar {
    private Long playerId;
    @JsonAlias("id")
    private Long avatarId;
    private String name;
    private String element;
    private String image;
    private Integer rarity ;
    private Integer fetter;
    private Integer level;
}

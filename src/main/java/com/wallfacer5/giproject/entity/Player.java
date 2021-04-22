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
    private Long playerId;
    private String username;
    private Stat stats;
    private List<Avatar> avatars;
}

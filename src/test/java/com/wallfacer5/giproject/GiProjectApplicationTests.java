package com.wallfacer5.giproject;

import com.wallfacer5.giproject.entity.Avatar;
import com.wallfacer5.giproject.entity.Player;
import com.wallfacer5.giproject.entity.Stat;
import com.wallfacer5.giproject.mapper.OwnedAvatarMapper;
import com.wallfacer5.giproject.mapper.StatMapper;
import com.wallfacer5.giproject.service.PlayerService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GiProjectApplicationTests {

	@Autowired
	PlayerService playerService;

	@Autowired
	StatMapper statMapper;

	@Autowired
	OwnedAvatarMapper ownedAvatarMapper;

	@Test
	void contextLoads() {

	}

	@Test
	void testPlayer(){
		Player player = playerService.getPlayerInfoByUid(1L);
		System.out.println(player);
	}

	@Test
	void testStat(){
		System.out.println(statMapper.getStatsByUid(1L));
	}

	@Test
	void insertStat(){
		Stat stat = new Stat(2L, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, "8-3");
		statMapper.insert(stat);
	}

	@Test
	void insertAvatar(){
		Avatar avatar = new Avatar(1L, 103L, "客情", "cryo", "url", 5,  10, 90);
		ownedAvatarMapper.insert(avatar);
	}

}

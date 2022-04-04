package com.liberty.poker.service;


import java.util.List;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;


public interface UserService {
	
	User save(User aUser);
	
	User createNew(User aUser);
	
	List<User> findByNameAndNicknameAndSession(String aName, String aNickname, PokerPlanningSession aSession);
	


}

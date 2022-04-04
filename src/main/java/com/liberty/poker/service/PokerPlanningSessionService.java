package com.liberty.poker.service;

import java.util.List;
import java.util.Optional;

import com.liberty.poker.entity.PokerPlanningSession;

public interface PokerPlanningSessionService {
	
	PokerPlanningSession save(PokerPlanningSession aSession);
	
	PokerPlanningSession create(PokerPlanningSession aSession);
	
	List<PokerPlanningSession> findByTitle(String aTitle);
	
	PokerPlanningSession findById(Long aIdSession);
	
	void delete(PokerPlanningSession aSession);

}

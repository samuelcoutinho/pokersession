package com.liberty.poker.service;


import java.util.List;

import com.liberty.poker.entity.DeckTypeValues;
import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.entity.VotesUserStory;

public interface UserStoryService {
	
	UserStory save(UserStory aUserStory);
	
	UserStory createNew(UserStory aUserStory);
	
	UserStory findById(Long aId);
	
	List<UserStory> findByIdAndSession(Long aId, PokerPlanningSession aSession);
	
	List<UserStory> findBySession(PokerPlanningSession aSession);
	
	List<DeckTypeValues> startVoting(UserStory userStory);
	
	List<VotesUserStory> getVotes(Long idUserStory);
	
	List<VotesUserStory> finishVotes(Long idUserStory);
	
	void delete(UserStory aUserStory);
	
	

}

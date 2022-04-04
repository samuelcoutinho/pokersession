package com.liberty.poker.service;



import com.liberty.poker.entity.VotesUserStory;


public interface VotesUserStoryService {
	
	VotesUserStory save(VotesUserStory aUser);
	
	VotesUserStory vote(VotesUserStory aUser);


}

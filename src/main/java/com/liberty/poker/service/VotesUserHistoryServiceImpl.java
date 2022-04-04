package com.liberty.poker.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.liberty.poker.entity.VotesUserStory;
import com.liberty.poker.repository.VotesUserStoryRepository;


@Service
public class VotesUserHistoryServiceImpl implements VotesUserStoryService {
	
	@Autowired
    private VotesUserStoryRepository votesUserStoryRepository;
	
	
	@Override
	public VotesUserStory save(VotesUserStory aVotesUserStory) {
		return votesUserStoryRepository.save(aVotesUserStory);
	}
	
	@Override
	public VotesUserStory vote(VotesUserStory aVotesUserStory) {
		return votesUserStoryRepository.save(aVotesUserStory);
		
	}

	
}

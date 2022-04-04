package com.liberty.poker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.entity.VotesUserStory;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.repository.PokerSessionRepository;
import com.liberty.poker.repository.UserStoryRepository;
import com.liberty.poker.repository.VotesUserStoryRepository;

@Service
public class PokerPlanningSessionServiceImpl implements PokerPlanningSessionService {
	
	
	@Autowired
    private PokerSessionRepository sessionRepository;
	
	@Autowired
    private UserStoryRepository userStoryRepository;
	
	@Autowired
    private VotesUserStoryRepository votesUserStoryRepository;
	
	@Override
	public PokerPlanningSession create(PokerPlanningSession aSession) {
		
		aSession.setId(null);
		return sessionRepository.save(aSession);
		
	}
	
	@Override
	public PokerPlanningSession save(PokerPlanningSession aSession) {
		
		if (aSession.getId()==0) {
			aSession.setId(null);
		}
		return sessionRepository.save(aSession);
		
	}
	
	@Override
	public List<PokerPlanningSession> findByTitle(String aTitle) {
		
		return sessionRepository.findByTitle(aTitle);
		
	}
	
	@Override
	public PokerPlanningSession findById(Long aIdSession) {
		Optional<PokerPlanningSession> optSession = sessionRepository.findById(aIdSession);
		if (!optSession.isPresent()) {
			throw new BusinessException("poker.session.id.notFound");
		}
		else {
			return optSession.get();

		}
		
	}
	
	@Override
	public void delete(PokerPlanningSession aSession) {
		
		List<UserStory> listUserStory = aSession.getUsersStories();
		for (UserStory userStory : listUserStory) {
			List<VotesUserStory> listVotes = votesUserStoryRepository.findByIdUserStory(userStory.getId());
			for (VotesUserStory vote : listVotes) {
				votesUserStoryRepository.delete(vote);
			}
		}
		
		sessionRepository.delete(aSession);
	}
	
}

package com.liberty.poker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liberty.poker.entity.DeckTypeValues;
import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.entity.VotesUserStory;
import com.liberty.poker.entity.constants.UserStoryStatusEnum;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.repository.UserStoryRepository;
import com.liberty.poker.repository.VotesUserStoryRepository;

@Service
public class UserStoryServiceImpl implements UserStoryService {
	
	@Autowired
    UserStoryRepository userStoryRepository;
	
	@Autowired
	DeckTypeValuesService deckTypeValuesService;
	
	@Autowired
    VotesUserStoryRepository votesUserStoryRepository;
	
	@Override
	public UserStory save(UserStory aUserStory) {
		return userStoryRepository.save(aUserStory);
	}
	
	@Override
	public UserStory createNew(UserStory aUserStory) {
		aUserStory.setStatus(UserStoryStatusEnum.PENDING.value);
		return userStoryRepository.save(aUserStory);
	}
	
	@Override
	public UserStory findById(Long aId){
		Optional<UserStory> optUs = userStoryRepository.findById(aId);
		return optUs.isPresent() ? optUs.get() : null;
	}
	
	@Override
	public List<UserStory> findByIdAndSession(Long aId, PokerPlanningSession aSession){
		return userStoryRepository.findByIdAndSession(aId, aSession);
	}
	
	@Override
	public List<UserStory> findBySession(PokerPlanningSession aSession){
		return userStoryRepository.findBySession(aSession);
	}
	
	@Override
	public List<DeckTypeValues> startVoting(UserStory userStory){
		
		// If status not PENDING or VOTED, return error.
		if ( (userStory.getStatus().equals(UserStoryStatusEnum.PENDING.value))||(userStory.getStatus().equals(UserStoryStatusEnum.VOTED.value)) ) {
			userStory.setStatus(UserStoryStatusEnum.VOTING.value);
			userStoryRepository.save(userStory);
		}
		else {
			throw new BusinessException("poker.validation.userStory.startVoting.forbidden");
		}
		
		// Success. Return available options to vote
		return deckTypeValuesService.findByDeckType(userStory.getSession().getDeckType().getId());
		
	}
	
	@Override
	public List<VotesUserStory> getVotes(Long idUserStory){
		return votesUserStoryRepository.findByIdUserStory(idUserStory);
		
	}
	@Override
	public List<VotesUserStory> finishVotes(Long idUserStory){
		Optional<UserStory> optUserStory = userStoryRepository.findById(idUserStory);
		if (optUserStory.isPresent()) {
			UserStory userStory = optUserStory.get();
			userStory.setStatus(UserStoryStatusEnum.VOTED.value);
			userStoryRepository.save(userStory);
			return votesUserStoryRepository.findByIdUserStory(idUserStory);
		}
		else {
			return new ArrayList<VotesUserStory>(); //empty
		}
	}
	
	@Override
	public void delete(UserStory aUserStory) {
		
		if (aUserStory.getStatus().equals(UserStoryStatusEnum.PENDING.value)) {
			
			List<VotesUserStory> listVotes = votesUserStoryRepository.findByIdUserStory(aUserStory.getId());
			for (VotesUserStory vote : listVotes) {
				votesUserStoryRepository.delete(vote);
			}
			userStoryRepository.delete(aUserStory);
		}
		else {
			throw new BusinessException("poker.validation.userStory.delete.forbidden");
		}
	}
	
}

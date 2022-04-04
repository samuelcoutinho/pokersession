package com.liberty.poker.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liberty.poker.entity.DeckTypeValues;
import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.repository.DeckTypeValuesRepository;
import com.liberty.poker.repository.UserRepository;


@Service
public class DeckTypeValuesServiceImpl implements DeckTypeValuesService {
	
	@Autowired
	DeckTypeValuesRepository deckTypeValuesRepository;
	
	@Override
	public List<DeckTypeValues> findByDeckType(Integer idDeckType){
		return deckTypeValuesRepository.findByDeckType(idDeckType);
	}
	
	
}

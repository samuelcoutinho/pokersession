package com.liberty.poker.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public User save(User aUser) {
		return userRepository.save(aUser);
	}
	
	@Override
	public User createNew(User aUser) {
		aUser.setId(null);
		return userRepository.save(aUser);
	}
	
	@Override
	public List<User> findByNameAndNicknameAndSession(String aName, String aNickname, PokerPlanningSession aSession){
		return userRepository.findByNameAndNicknameAndSession(aName, aNickname, aSession);
	}
	
	
}

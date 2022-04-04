package com.liberty.poker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.entity.UserStory;


@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> { 
	
	List<User> findByNameAndNicknameAndSession(String aName, String aNickname, PokerPlanningSession aSession);
	

}

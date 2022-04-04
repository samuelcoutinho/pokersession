package com.liberty.poker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;


@Repository
public interface UserStoryRepository extends JpaSpecificationExecutor<UserStory>, JpaRepository<UserStory, Long> { 
	
	List<UserStory> findByIdAndSession(Long aId, PokerPlanningSession aSession);
	
	List<UserStory> findBySession(PokerPlanningSession aSession);

}

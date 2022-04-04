package com.liberty.poker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.liberty.poker.entity.PokerPlanningSession;


@Repository
public interface PokerSessionRepository extends JpaSpecificationExecutor<PokerPlanningSession>, JpaRepository<PokerPlanningSession, Long> { 

	List<PokerPlanningSession> findByTitle(String aTitle);

}

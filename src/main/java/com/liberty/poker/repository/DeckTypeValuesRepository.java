package com.liberty.poker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.liberty.poker.entity.DeckTypeValues;
import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.entity.UserStory;


@Repository
public interface DeckTypeValuesRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> { 
	
	
	// Used this option for knowledge reasons
	@Query("SELECT D FROM DeckTypeValues D WHERE D.idDeckType = :idDeckType ORDER BY D.value ASC ")
	List<DeckTypeValues> findByDeckType(@Param("idDeckType") Integer idDeckType);
	

}

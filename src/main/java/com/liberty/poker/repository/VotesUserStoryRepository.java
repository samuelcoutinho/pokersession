package com.liberty.poker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.liberty.poker.entity.VotesUserStory;


@Repository
public interface VotesUserStoryRepository extends JpaSpecificationExecutor<VotesUserStory>, JpaRepository<VotesUserStory, Long> { 
	
	List<VotesUserStory> findByIdUserStory(Long idUserStory);

}

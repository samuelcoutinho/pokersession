package com.liberty.poker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liberty.poker.entity.DeckTypeValues;
import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.entity.VotesUserStory;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserStoryService;
import com.liberty.poker.service.VotesUserStoryService;
import com.liberty.poker.validator.PokerPlanningSessionValidator;
import com.liberty.poker.validator.UserStoryValidator;
import com.liberty.poker.validator.VotesUserStoryValidator;


@CrossOrigin
@RestController
@RequestMapping(value = "/votes")
public class VotesUserStoryController {
	
	Logger logger = LoggerFactory.getLogger(VotesUserStoryController.class);
	
	@Autowired
	VotesUserStoryService votesUserStoryService;
	

	@Autowired
    VotesUserStoryValidator votesUserStoryValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.setValidator(votesUserStoryValidator);
    }
    

    @PostMapping
	public ResponseEntity<?> vote(@RequestBody @Valid VotesUserStory votesUserStoryBean, HttpServletRequest request) {
		try {
			VotesUserStory voteUserStory = votesUserStoryService.vote(votesUserStoryBean);
			logger.info("VotesUserStory [" + voteUserStory.getId() + "] successfully saved");
			return new ResponseEntity<VotesUserStory>(voteUserStory,HttpStatus.CREATED);
		
		
		} catch (Exception e) {
			logger.error("VotesUserStory  [" + votesUserStoryBean.getValue() + "] failed to save");
			e.printStackTrace();
			return new ResponseEntity<VotesUserStory>(votesUserStoryBean,HttpStatus.BAD_REQUEST);
		}
		
	}
    
    

}

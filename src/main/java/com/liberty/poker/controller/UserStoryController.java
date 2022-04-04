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
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.liberty.poker.validator.PokerPlanningSessionValidator;
import com.liberty.poker.validator.UserStoryValidator;


@CrossOrigin
@RestController
@RequestMapping(value = "/userStories")
public class UserStoryController {
	
	Logger logger = LoggerFactory.getLogger(UserStoryController.class);
	
	@Autowired
	UserStoryService userStoryService;
	
	
	@Autowired
    UserStoryValidator userStoryValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.setValidator(userStoryValidator);
    }
    
	
    @PostMapping
	public ResponseEntity<?> createUserStory(@RequestBody @Valid UserStory userStoryBean, HttpServletRequest request) {
		try {
			UserStory userStory = userStoryService.createNew(userStoryBean);
			logger.info("UserStory [" + userStory.getId() +
					"] successfully saved");
			return new ResponseEntity<UserStory>(userStory,HttpStatus.CREATED);
		
		
		} catch (Exception e) {
			logger.error("UserStory  [" + userStoryBean.getDescription() + "] failed to save");
			e.printStackTrace();
			return new ResponseEntity<UserStory>(userStoryBean,HttpStatus.BAD_REQUEST);
		}
		
	}
    
    @GetMapping("/{idUserHistory}/votes")
    public List<VotesUserStory> getVotes(@PathVariable long idUserHistory) {
    	   	return userStoryService.getVotes(idUserHistory);
    }
    
    @GetMapping("/{idUserHistory}/finish-votes")
    public List<VotesUserStory> finshVotes(@PathVariable long idUserHistory) {
    	   	return userStoryService.finishVotes(idUserHistory);
    }
    
    @DeleteMapping("/{idUserHistory}")
    public ResponseEntity<?> deleteUserStory(@PathVariable long idUserHistory) {
    	UserStory userStory = userStoryService.findById(idUserHistory);
    	if (userStory != null) {
    		userStoryService.delete(userStory);
    	}
    	else {
    		throw new BusinessException("poker.validation.userStory.notfound");
    	}
        return ResponseEntity.ok().build(); 
    }
    
    @GetMapping("/{idUserStory}/start-voting")
    public List<DeckTypeValues> startVoting(@PathVariable long idUserStory) {
    	UserStory userStory = userStoryService.findById(idUserStory);
    	if (userStory != null) {
    		return userStoryService.startVoting(userStory);
    	}
    	else {
    		throw new BusinessException("poker.validation.userStory.notfound");
    	}
    }
    
    

}

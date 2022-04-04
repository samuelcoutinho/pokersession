package com.liberty.poker.controller;

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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserService;
import com.liberty.poker.service.UserStoryService;
import com.liberty.poker.validator.PokerPlanningSessionValidator;
import com.liberty.poker.validator.UserStoryValidator;
import com.liberty.poker.validator.UseryValidator;


@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	
	@Autowired
    UseryValidator validator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.setValidator(validator);
    }
    
    
	
    @PostMapping
	public ResponseEntity<?> createUser(@RequestBody @Valid User userBean, HttpServletRequest request) {
		try {
			User user = userService.createNew(userBean);
			logger.info("User [" + user.getId() + "] successfully saved");
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
		
		} catch (Exception e) {
			logger.error("User  [" + userBean.getName()+ "] failed to save");
			e.printStackTrace();
			return new ResponseEntity<User>(userBean,HttpStatus.BAD_REQUEST);
		}
		
	}

}

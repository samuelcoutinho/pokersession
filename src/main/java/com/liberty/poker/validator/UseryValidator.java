package com.liberty.poker.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.User;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserService;
import com.liberty.poker.service.UserStoryService;

@Component 
public class UseryValidator implements Validator {
	
		@Autowired
		MessageSource messageSource;
	
	 	@Autowired
	    private UserService userService;
	    
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return User.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        
	    	User user = (User) target;
	        
	    	// Checks if the ID exists for that Session
	        if(!this.userService.findByNameAndNicknameAndSession(user.getName(), user.getNickname(), user.getSession()).isEmpty()) {
	            throw new BusinessException("poker.validation.userStory.nameNickname.duplicity"); 
	            
	           // Full error message
	          //errors.rejectValue("name",messageSource.getMessage("poker.validation.userStory.nameNickname.duplicity",null,Locale.getDefault()),"The name/nickname already exist in the Session.");
	        }

	        
	        
	    }

}



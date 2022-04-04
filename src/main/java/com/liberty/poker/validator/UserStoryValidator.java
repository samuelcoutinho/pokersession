package com.liberty.poker.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserStoryService;

@Component 
public class UserStoryValidator implements Validator {
	
		@Autowired
		MessageSource messageSource;
	
	 	@Autowired
	    private UserStoryService userStoryService;
	    
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return UserStory.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        
	    	UserStory userStory = (UserStory) target;
	        
	    	// Checks if the ID exists for that Session
	        if(!this.userStoryService.findByIdAndSession(userStory.getId(), userStory.getSession()).isEmpty()) {
	        	throw new BusinessException("poker.validation.userStory.id.duplicity");          
	        	
	        	// Full error message
	        	//errors.rejectValue("id",messageSource.getMessage("poker.validation.userStory.id.duplicity",null,Locale.getDefault()),"The ID already exists in the Session.");
	                    
	        }

	        
	        
	    }

}



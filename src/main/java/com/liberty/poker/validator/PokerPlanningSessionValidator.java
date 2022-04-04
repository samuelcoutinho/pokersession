package com.liberty.poker.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.service.PokerPlanningSessionService;

@Component 
public class PokerPlanningSessionValidator implements Validator {
	
		@Autowired
		MessageSource messageSource;
	
	 	@Autowired
	    private PokerPlanningSessionService pokerPlanningSessionService;
	    
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return PokerPlanningSession.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        
	    	PokerPlanningSession session = (PokerPlanningSession) target;
	        
	        if(!this.pokerPlanningSessionService.findByTitle(session.getTitle()).isEmpty()) {
	        	throw new BusinessException("poker.validation.session.title.duplicity");          
	        	
	        	// Full error message
	        	//errors.rejectValue("title",messageSource.getMessage("poker.validation.session.title.duplicity",null,Locale.getDefault()),"The title already exists.");
	        }

	        
	        
	    }

}



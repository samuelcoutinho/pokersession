package com.liberty.poker.validator;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liberty.poker.entity.PokerPlanningSession;
import com.liberty.poker.entity.UserStory;
import com.liberty.poker.entity.VotesUserStory;
import com.liberty.poker.entity.constants.UserStoryStatusEnum;
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.repository.UserStoryRepository;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserStoryService;
import com.liberty.poker.service.VotesUserStoryService;

@Component 
public class VotesUserStoryValidator implements Validator {
	
		@Autowired
		MessageSource messageSource;
	
	 	
	 	@Autowired
	    private UserStoryRepository userStoryRepository;
	    
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return VotesUserStory.class.isAssignableFrom(clazz);
	    }

	    @Override
	    public void validate(Object target, Errors errors) {
	        
	    	VotesUserStory votesUserStory = (VotesUserStory) target;
	        
	    	Optional<UserStory> userStoryOpt = userStoryRepository.findById(votesUserStory.getIdUserStory());
			if (userStoryOpt.isPresent()) {
				if (!userStoryOpt.get().getStatus().equals(UserStoryStatusEnum.VOTING.value)) {
					throw new BusinessException("poker.validation.userStory.voting.forbidden");
				}
			}

	        
	        
	    }

}



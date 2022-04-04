package com.liberty.poker.controller;

import java.util.List;
import java.util.Optional;

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
import com.liberty.poker.exception.BusinessException;
import com.liberty.poker.service.PokerPlanningSessionService;
import com.liberty.poker.service.UserStoryService;
import com.liberty.poker.validator.PokerPlanningSessionValidator;


@CrossOrigin
@RestController
@RequestMapping(value = "/sessions")
public class PokerSessionController {
	
	Logger logger = LoggerFactory.getLogger(PokerSessionController.class);
	
	@Autowired
	PokerPlanningSessionService pokerPlanningSessionService;
	
	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
    PokerPlanningSessionValidator pokerPlanningSessionValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.setValidator(pokerPlanningSessionValidator);
    }
	
    @PostMapping
	public ResponseEntity<?> createSession(@RequestBody @Valid PokerPlanningSession sessionBean, HttpServletRequest request) {
		try {
			PokerPlanningSession pokerSession = pokerPlanningSessionService.create(sessionBean);
			logger.info("Poker session [" + pokerSession.getId() + "] successfully saved");
			return new ResponseEntity<>(pokerSession, HttpStatus.CREATED);
		
		
		} catch (Exception e) {
			logger.error("Poker session  [" + sessionBean.getTitle() + "] failed to save");
			e.printStackTrace();
			return new ResponseEntity<PokerPlanningSession>(sessionBean,HttpStatus.BAD_REQUEST);
		}
		
	}
    
    
    @GetMapping("/{idSession}")
   	public PokerPlanningSession getSession(@PathVariable long idSession) {
       	return pokerPlanningSessionService.findById(idSession);
   	}
    
    @DeleteMapping("/{idSession}")
    public ResponseEntity<?> deleteSession(@PathVariable @Valid long idSession) {
    	PokerPlanningSession session = pokerPlanningSessionService.findById(idSession);
    	if (session != null) {
    		pokerPlanningSessionService.delete(session);
    	}
    	else {
    		throw new BusinessException("poker.session.id.notFound");
    	}
        return ResponseEntity.ok().build(); 
    }
    
    

}

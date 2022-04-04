package com.liberty.poker.service;


import java.util.List;

import com.liberty.poker.entity.DeckTypeValues;



public interface DeckTypeValuesService {
	
	List<DeckTypeValues> findByDeckType(Integer idDeckType);
	


}

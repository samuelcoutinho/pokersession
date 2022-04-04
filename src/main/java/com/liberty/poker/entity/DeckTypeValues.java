package com.liberty.poker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Embeddable
@Table(name = "DECK_TYPE_VALUES")
public class DeckTypeValues {
	
	@Id 
	@Column(name = "ID_DECK_TYPE_VALUES")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "VALUE")
	private Double value;
	
	@Column(name = "ID_DECK_TYPE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDeckType;
	
	
	
	
	
	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Double getValue() {
		return value;
	}





	public void setValue(Double value) {
		this.value = value;
	}





	public Integer getIdDeckType() {
		return idDeckType;
	}





	public void setIdDeckType(Integer idDeckType) {
		this.idDeckType = idDeckType;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeckTypeValues other = (DeckTypeValues) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

}

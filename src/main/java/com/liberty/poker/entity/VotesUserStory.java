package com.liberty.poker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Embeddable
@Table(name = "VOTES_USER_STORY")
public class VotesUserStory {
	
	@Id 
	@Column(name = "ID_VOTES_USER_STORY")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ID_SESSION")
	@NotNull
	private Long idSession;
	
	@Column(name = "ID_USER")
	@NotNull
	private Long idUser;
	
	@Column(name = "ID_USER_STORY")
	@NotNull
	private Long idUserStory;
	
	@Column(name = "VALUE")
	@NotNull
	private Double value;
	
	


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}





	public Long getIdSession() {
		return idSession;
	}




	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}




	public Long getIdUser() {
		return idUser;
	}




	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}




	public Long getIdUserStory() {
		return idUserStory;
	}




	public void setIdUserStory(Long idUserStory) {
		this.idUserStory = idUserStory;
	}




	public Double getValue() {
		return value;
	}




	public void setValue(Double value) {
		this.value = value;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotesUserStory other = (VotesUserStory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

}

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
@Table(name = "USER")
public class User {
	
	@Id 
	@Column(name = "ID_USER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	@Size(max=50)
	@NotNull
	private String name;
	
	@Column(name = "NICKNAME")
	@Size(max=50)
	@NotNull
	private String nickname;
	
	@ManyToOne
	@JoinColumn(name = "ID_SESSION")
	@JsonBackReference
	@NotNull
	private PokerPlanningSession session;
	
	



	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getNickname() {
		return nickname;
	}






	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	



	public PokerPlanningSession getSession() {
		return session;
	}






	public void setSession(PokerPlanningSession session) {
		this.session = session;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

}

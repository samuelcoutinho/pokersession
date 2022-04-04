package com.liberty.poker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;






@Entity
@Embeddable
@Table(name = "SESSION")
public class PokerPlanningSession {

	@Id 
	@Column(name = "ID_SESSION")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TITLE")
	@NotBlank
	@Size(max=100)
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER) // default is EAGER
	@JoinColumn(name = "ID_DECK_TYPE")
	@NotNull
	private DeckType deckType;
	
	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "session")
    @JsonManagedReference
    private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    @JsonManagedReference
    private List<UserStory> usersStories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DeckType getDeckType() {
		return deckType;
	}

	public void setDeckType(DeckType deckType) {
		this.deckType = deckType;
	}
	
	
	
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<UserStory> getUsersStories() {
		return usersStories;
	}

	public void setUsersStories(List<UserStory> usersStories) {
		this.usersStories = usersStories;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokerPlanningSession other = (PokerPlanningSession) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

}

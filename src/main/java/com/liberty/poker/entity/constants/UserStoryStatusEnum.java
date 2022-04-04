package com.liberty.poker.entity.constants;

public enum UserStoryStatusEnum {
	
	PENDING("PENDING"), VOTING("VOTING"), VOTED("VOTED");
	
	public final String value;
	

	private UserStoryStatusEnum(String value) {
		this.value = value;
	}

	
}

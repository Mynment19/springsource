package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class ChangeDTO {
	//changePwd.jsp 와 일치
	String userid;
	
	String currentPassword;
	String newPassword;
	String confirmPassword;
	
	public boolean passwordEquals() {
		return newPassword.equals(confirmPassword);
	}
	
}

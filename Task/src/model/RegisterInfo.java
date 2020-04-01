package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterInfo {
	private String userId;
	private String pass;
	private String mail;
	private String userName;
	private Timestamp createdAt;

	public RegisterInfo(String userId, String pass, String mail, String userName) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.userName = userName;
	}

}

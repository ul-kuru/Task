package model;



import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
	private String userId;
	private String pass;
	private String mail;
	private String userName;
	private Timestamp createdAt;

	public User(String userId, String pass, String mail, String userName) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.userName = userName;
	}

}

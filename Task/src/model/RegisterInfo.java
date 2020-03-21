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

}

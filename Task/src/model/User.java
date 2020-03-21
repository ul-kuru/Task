package model;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private String userId;
	private String pass;
	private String mail;
	private String userName;
	private Timestamp createdAt;
}

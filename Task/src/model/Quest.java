package model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Quest implements Serializable{
	private int questId;
	private String title;
	private String details;
	private Timestamp deadline;
	private boolean cleared;
	private String createdUserId;
	private Timestamp createdAt;

}

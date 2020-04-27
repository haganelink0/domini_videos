package com.videosdata;

import java.time.LocalDate;
import java.util.HashMap;


public class User {
	private String userName;
	private String userLastName;
	private String password;
	private LocalDate registerDate;
	private HashMap<String,Video> videoList;
	
	
	
	public User(String userName, String userLastName, String password) throws NullError {
		this.userName = userName;
		this.userLastName = userLastName;
		this.password = password;
		this.videoList = new HashMap<String,Video>();
		this.registerDate = LocalDate.now();
		
		if (userName.isEmpty() || userName.isBlank()) {
			throw new NullError("Name can't be empty");
		}
		
		if (userLastName.isEmpty() || userLastName.isBlank()) {
			throw new NullError("Name can't be empty");
		}
		
		if (password.isEmpty() || password.isBlank()) {
			throw new NullError("Name can't be empty");
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	
	
	public HashMap<String, Video> getVideoList() {
		return videoList;
	}
	@Override
	public String toString() {
		return "Username: " + userName + "\n Last Name: " + userLastName + "\n Password: " + password
				+ "\n register Date: " + registerDate;
	}
	
	
	public void addVideo(Video video) {
		this.videoList.put(video.getTitle(), video);
	}
	
	public void removeVideo(Video video) {
		this.videoList.remove(video.getTitle());
	}
	
	public void getVideo(String title) {
		this.videoList.get(title);
	}
	
}

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((videoList == null) ? 0 : videoList.hashCode());
		return result;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (videoList == null) {
			if (other.videoList != null)
				return false;
		} else if (!videoList.equals(other.videoList))
			return false;
		return true;
	}
	
	
	

}

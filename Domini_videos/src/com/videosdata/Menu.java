package com.videosdata;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Menu {
	private Scanner reader;
	private HashMap<String, User>userList;
	
	public Menu(Scanner reader) {
		this.reader = reader;
		this.userList = new HashMap<String, User>();
	}
	
	//Main tree of the program
	public void start() {
		Utilities.welcome();
		User sesionUser = firstLoop();	
		String command = "y";
		do {
			secondLoop(sesionUser);
			command = Utilities.askInput(reader, "Do you want to do something else? (Y/N");
		} while(command.equalsIgnoreCase("y"));
		System.out.println("Thanks for using our service!");
	}
	
	//first loop to get an user from the client, a new one or an existing one
	public User firstLoop() {
		User sesionUser = null;
		Boolean stopper = true;
		while(stopper) {
			String command = Utilities.askInput(reader, "Do you want to login, create a newuser or exit?");
			switch(command) {
			
			case "login":
				sesionUser = login();
				stopper = false;
				break;
			
			case "newuser":
				sesionUser = newUser();
				stopper = false;
				break;
			
			case "exit":
				stopper = false;
				break;
			
			default:
				System.out.println("Unknown command!");
			}	
		}
		return sesionUser;
	}
	
	//second loop goes through the user options
	public void secondLoop(User user) {
		String command = Utilities.askInput(reader, "Choose what you want to do: Edit your username(edit), add a video (add), "
											+ "delete a video (delete) or view your videos (view)");
		switch(command) {
		case "edit":
			editUser(user);
			break;
		case "add":
			addVideo(user);
			break;
		case "delete":
			deleteVideo(user);
			break;
		case "view":
			viewVideos(user);
			break;
		default:
				System.out.println("Unknown command!");
			
		}
	}
	
	//returns the user given the correct user and password
	public User login() {
		User loggedUser = null;
		while(true) {
			String name = Utilities.askInput(reader, "Please, insert your username:");
			if (userList.containsKey(name)) {
				String password = Utilities.askInput(reader, "Please insert your password");
				if(userList.get(name).getPassword().equalsIgnoreCase(password)) {
					loggedUser = userList.get(name);
					break;
					
				} else {
					System.out.println("Incorrect password");
				}
			} else {
				System.out.println("incorrect username");
			}
		}
		return loggedUser;

	}
	
	//creates a new user
	public User newUser() {
		User user1 = null;
		Boolean holder = false;
		do {
			String name = Utilities.askInput(reader, "What is your name?");
			name = Utilities.isOriginal(reader, name, "username", userList);
			String lastName = Utilities.askInput(reader, "What is your last name?");
			String password = Utilities.askInput(reader, "Please, select a password");
			password = Utilities.confirmPassword(reader, password);
			try {
				user1 = new User(name, lastName, password);
			} catch (NullError e) {
				e.printStackTrace();
				System.out.println("User information can't be empty");
				holder = true;
			}
			holder = false;
		} while(holder);
		return user1;
	}
	
	//edits user information
	public void editUser(User user) {
		boolean aux = true;
		while(aux) {
			System.out.println(user);
			String command = Utilities.askInput(reader, "What do you want to edit?"
														+ " \n Options: 'username', l'astname', 'password' & 'exit'");
			switch(command) {
			case "name":
					String name = Utilities.askInput(reader, "Write your new name");
					name = Utilities.isOriginal(reader, name,"username", userList);
				break;
				
			case "lastname":
				String lastName = Utilities.askInput(reader, "Write your new last name");
				userList.get(user.getUserName()).setUserLastName(lastName);
				break;
				
			case "password":
				String password = Utilities.askInput(reader, "Write your new password");
				password = Utilities.confirmPassword(reader, password);
				userList.get(user.getUserName()).setPassword(password);
				break;
				
			case "exit":
				aux = false;
				break;
			default:
				System.out.println("Unknown command");
				
			}
			
		}
		
	}
	
	//adds a new video to the user
	public void addVideo(User user) {
		String url = Utilities.askInput(reader, "Write the url for the video:");
		String title = Utilities.askInput(reader, "Write the title for the video:");
		List<String> tags = Utilities.addTags(reader);
		Video newVideo = null;
		try {
			newVideo = new Video(url, title, tags);
			
		} catch (NullError e) {
			e.printStackTrace();
			System.out.println("The video hasn't been added");
		}
		if (user.getVideoList().containsKey(title)) {
			System.out.println("A video with the same title is already on your list");
		} else {
			user.addVideo(newVideo);
		}
	}
	
	//deletes a video from the user
	public void deleteVideo(User user) {
		String videoTitle = Utilities.askInput(reader, "Type the title of the video");
		if (user.getVideoList().containsKey(videoTitle)) {
			Video video = user.getVideoList().get(videoTitle);
			user.removeVideo(video);
		} else {
			System.out.println("The title isn't in your video list");
		}
		
	}
	
	//prints all the videos from the user
	public void viewVideos(User user) {
		System.out.println(user.getVideoList());
	}


}

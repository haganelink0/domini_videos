package com.videosdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Utilities {
	
	public static void welcome() {
		System.out.println("Welcome to the Video Program");
		System.out.println("*****************************");
	}
	
	//Asks a question an return a string with the answer
	public static String askInput (Scanner reader, String option) {
		System.out.println(option);
		return reader.nextLine();
	}
	
	//checks if the password input is correct twice
	public static String confirmPassword(Scanner reader, String password) {
		String confirmed ="";
		do {
			System.out.println("please, type again your password to confirm");
			confirmed = reader.nextLine();
		} while (!password.equals(confirmed));
		return confirmed;
	}
	
	//checks if the username is new
	public static String isOriginal(Scanner reader, String originalKey, String subject, HashMap<String,User> userList) {
		String confirmed = "";
		while(!originalKey.equals(confirmed)) {
			if (userList.containsKey(originalKey)) {
				System.out.println("This "+ subject + " is already taken, please insert a new one:");
				confirmed = reader.nextLine();
			} else {
				confirmed = originalKey;
			}
		}
		return confirmed;
	}
	
	//loop to add tags
	public static ArrayList<String> addTags (Scanner reader) {
		ArrayList<String> tagList = new ArrayList<String>();
		while(true) {
			System.out.println("Introduce a tag or type exit to exit:");
			String tag = reader.nextLine();
			if (tag.equalsIgnoreCase("exit")) {
				break;
			} else {
				tagList.add(tag);
			}
		}
		return tagList;
	}

}

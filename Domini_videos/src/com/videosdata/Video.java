package com.videosdata;

import java.util.ArrayList;
import java.util.List;

public class Video  {
	private String url;
	private String title;
	private List<String> tags;

	public Video(String url, String title, List<String> tags) throws NullError {
		this.url = url;
		this.title = title;
		this.tags = new ArrayList<String>();
		
		if (url.isEmpty())
			throw new NullError ("url can't be empty");
		
		if (title.isEmpty()) 
			throw new NullError ("title can't be empty");
		
		if (tags.isEmpty())
			throw new NullError ("You need at least one tag");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		String StringTag = "";
		for (String tag : tags) {
			StringTag += tag + ", ";
		}
		return "Title: " + title + "\n URL: " + url + "\n Tags" + StringTag;
	}

	public void addTag(String tag) {
		this.tags.add(tag);
	}

}

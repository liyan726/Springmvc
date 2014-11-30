package com.srpingmvc.entry;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id;
	private String name;
	private List<Integer> cards;
	private String path;
	
	private FilesInfo file;
	
	
	public FilesInfo getFile() {
		return file;
	}
	public void setFile(FilesInfo file) {
		this.file = file;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Integer> getCards() {
		return cards;
	}
	public void setCards(List<Integer> cards) {
		this.cards = cards;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="用户名不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}

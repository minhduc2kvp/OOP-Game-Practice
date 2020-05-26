package com.minhvu.game.model;

public class Player {
	private String name;
	private int score;
	
	public Player() {
		this.score = 0;
	}
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
}

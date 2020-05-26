package com.minhvu.game.model;

public class RobotPlayer extends Player{
	private String[] loseEmoij = 
		{"Haizz, các chú hên lắm !","Đen thôi, đỏ quên đi.","Dăm ba thằng nhóc, chơi lại ván nữa coi."};
	private String[] winEmoij = 
		{"Tưởng dư nào, cũng chỉ có dư này","Các chú còn non và xanh lắm","Game là dễ"};
	
	public RobotPlayer(String name) {
		super(name);
	}
	
	public String getLoseEmoij() {
		return this.loseEmoij[(int) Math.round(Math.random() * (this.loseEmoij.length - 1))];
	}
	
	public String getWinEmoij() {
		return this.winEmoij[ (int) Math.round(Math.random() * (this.winEmoij.length - 1))];
	}
}

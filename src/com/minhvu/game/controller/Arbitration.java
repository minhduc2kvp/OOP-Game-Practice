package com.minhvu.game.controller;

import java.util.List;

import com.minhvu.game.model.Player;
import com.minhvu.game.model.RobotPlayer;

public class Arbitration {
	
	private List<Player> players;
	private Dice[] dices = {new Dice(),new Dice(),new Dice(),new Dice()};
	private Player[] turn = new Player[4];
	
	public Arbitration() {
		
	}
	
	public void setListPlayer(List<Player> players) {
		this.players = players;
		int i = 1;
		while(this.players.size() < 4) {
			this.players.add(new RobotPlayer("Robot-" + i));
			i++;
		}
		int j = 0;
		while(true) {
			int k = (int) Math.round( Math.random() * 3 );
			if(this.turn[k] == null) {
				this.turn[k] = this.players.get(j);
				j++;
			}
			if(this.turn[0] != null && this.turn[1] != null && this.turn[2] != null && this.turn[3] != null) {
				break;
			}
		}
	}
	
	public void startGame() {
		int i = 0;
		while(!checkEndGame()) {
			int score = this.dices[i].runDice();
			addScoreForPlayer(i, score);
			System.out.println(this.turn[i].getName() + " quay được " + score + " điểm => điểm hiện tại : " + this.turn[i].getScore());
			i++;
			if(i>3) {
				i = 0;
			}
		}
	}
	
	private void addScoreForPlayer(int i, int score) {
		int currentScore = this.turn[i].getScore();
		if(currentScore + score > 21) {
			this.turn[i].setScore(0);
		}else {
			this.turn[i].addScore(score);;
		}
	}
	
	private boolean checkEndGame() {
		for(int i = 0; i<4 ; i++) {
			if(this.turn[i].getScore() == 21) {
				System.out.println(" ---- Chúc mừng " + this.turn[i].getName() + " là người thắng cuộc ^v^v^");
				for(int k = 0 ; k< 4 ; k++) {
					if(this.turn[k] instanceof RobotPlayer) {
						if(k == i) {
							System.out.println(this.turn[i].getName() + " : " + ((RobotPlayer) this.turn[i]).getWinEmoij());
						}else {
							System.out.println(this.turn[k].getName() + " : " + ((RobotPlayer) this.turn[k]).getLoseEmoij());;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
	

}

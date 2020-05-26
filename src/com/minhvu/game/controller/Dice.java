package com.minhvu.game.controller;

public class Dice {
	
	private int score[] = new int[5]; 			// 1 2 3 4
	private int socreLargePersen;  				// 0
	
	public Dice() {
		this.socreLargePersen = (int) Math.round(Math.random() * 5) + 1;
		int s = 1;
		for(int i = 0; i<5 ; i++) {
			if(s != this.socreLargePersen) {
				this.score[i] = s;
			}else {
				s++;
				this.score[i] = s;
			}
			s++;
		}
	}
	
	public int runDice() {
		int score = -1;
		if((int) Math.round(Math.random() * 4) == 0) {
			score = this.socreLargePersen;
		}else {
			score = this.score[(int) Math.round( Math.random() * (this.score.length - 1) )];
		}
		return score;
	}
	
}

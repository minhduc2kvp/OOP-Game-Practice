package com.minhvu.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.minhvu.game.controller.Arbitration;
import com.minhvu.game.controller.Dice;
import com.minhvu.game.model.PersonPlayer;
import com.minhvu.game.model.Player;
import com.minhvu.game.model.RobotPlayer;

public class Main {
	
	public static void main(String[] args) {
		Arbitration arbitration = new Arbitration();
		List<Player> players = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		int numberPlayers = 0;
		while(numberPlayers <=0 || numberPlayers > 4) {
			System.out.println("Nhập số người chơi (Số người chơi tối đa là 4) : ");
			try {
				numberPlayers = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Nhập thông tin không chính xác. Mời bạn thử lại");
				numberPlayers = -1;
			}
		}
		for(int i = 0 ; i<numberPlayers; i++) {
			System.out.println("Nhập tên người chơi : ");
			String name = new Scanner(System.in).nextLine();
			players.add(new PersonPlayer(name));
		}
		arbitration.setListPlayer(players);
		arbitration.startGame();
	}
	
}

package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.menu.Menu;

public class TicTacToe {

	private Game game;
	
	private Menu menu;
	
	private TicTacToe(){
		game = new Game(false);
		menu = new Menu(game);
	}
	
	private void exec() {
		menu.execute();
	}
	
	public static void main(String[] args){
		new TicTacToe().exec();
	}
}

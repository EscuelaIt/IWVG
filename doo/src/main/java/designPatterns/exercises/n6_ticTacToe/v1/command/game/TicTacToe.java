package designPatterns.exercises.n6_ticTacToe.v1.command.game;

import designPatterns.exercises.n6_ticTacToe.v1.command.menu.Menu;

public class TicTacToe {

	private Game game;
	
	private Menu menu;
	
	private TicTacToe(){
		game = new Game();
		menu = new Menu(game);
	}
	
	private void exec() {
		menu.execute();
	}
	
	public static void main(String[] args){
		new TicTacToe().exec();
	}
}

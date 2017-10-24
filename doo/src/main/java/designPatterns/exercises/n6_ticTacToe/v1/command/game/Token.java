package designPatterns.exercises.n6_ticTacToe.v1.command.game;

public enum Token {
	X('x'),
	O('o'),
	VOID('_');
	
	private char symbol;

	private Token(char symbol){
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}

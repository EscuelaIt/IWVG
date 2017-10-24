package designPatterns.exercises.n6_ticTacToe.v2.memento.game;

import designPatterns.exercises.n6_ticTacToe.v2.memento.utils.IO;

public class Turn {

	private Token token;

	Turn(Token token){
		this.token = token;
	}
	
	public Turn() {
		this(Token.X);
	}

	public Token take() {
		return token;
	}

	public Token notTake() {
		return Token.values()[(token.ordinal() + 1)
				% (Token.values().length - 1)];
	}

	public void change() {
		token = this.notTake();
	}

	public void write() {
		IO.instance().writeln("Turno para " + token.getSymbol());
	}

}

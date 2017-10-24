package designPatterns.exercises.n6_ticTacToe.v1.command.game;

import designPatterns.exercises.n6_ticTacToe.v1.command.utils.IO;

public class Turn {

	private Token token;

	public Turn() {
		token = Token.X;
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

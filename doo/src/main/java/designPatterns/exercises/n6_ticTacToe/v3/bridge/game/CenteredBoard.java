package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

public class CenteredBoard extends Board {

	public CenteredBoard(Token token) {
		super();
		this.put(new Coordinate(1,1), token);
	}
}

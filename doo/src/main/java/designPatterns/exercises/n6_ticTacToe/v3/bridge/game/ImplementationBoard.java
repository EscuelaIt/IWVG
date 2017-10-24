package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

public interface ImplementationBoard {

	void write();

	boolean complete();

	boolean existTicTacToe();

	boolean full(Coordinate coordinate, Token token);
	
	void put(Coordinate coordinate, Token token);

}

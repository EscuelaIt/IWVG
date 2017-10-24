package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

public class Board {

	public static final int DIMENSION = 3;
	
	private ImplementationBoard implementationBoard;
	
	public Board() {
		implementationBoard = new TabularBoard();
	}

	public void write() {
		implementationBoard.write();
	}

	public boolean complete() {
		return implementationBoard.complete();
	}

	public boolean existTicTacToe() {
		return implementationBoard.existTicTacToe();
	}

	public boolean full(Coordinate coordinate, Token token) {
		return implementationBoard.full(coordinate, token);
	}

	public boolean empty(Coordinate coordinate) {
		return this.full(coordinate, Token.VOID);
	}

	public void put(Coordinate coordinate, Token token) {
		implementationBoard.put(coordinate, token);
	}

	public void remove(Coordinate coordinate) {
		this.put(coordinate, Token.VOID);
	}

}

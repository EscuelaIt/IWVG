package designPatterns.exercises.n6_ticTacToe.v1.command.game;

public class Game {

	private Board board;
	
	private Turn turn;
	
	public Game(){
		board = new Board();
		turn = new Turn();
	}
	
	public void write() {
		board.write();
		turn.write();
	}

	public boolean complete() {
		return board.complete();
	}

	public boolean existTicTacToe() {
		return board.existTicTacToe();
	}
	
	public boolean full(Coordinate coordinate) {
		return board.full(coordinate, turn.take());
	}

	public boolean empty(Coordinate coordinate) {
		return board.empty(coordinate);
	}

	public void put(Coordinate coordinate) {
		board.put(coordinate, turn.take());
		turn.change();
	}

	public void move(Coordinate origin, Coordinate target) {
		board.remove(origin);
		board.put(target, turn.take());
		turn.change();
	}
	
	public void unPut(Coordinate coordinate) {
		turn.change();
		board.remove(coordinate);
	}

	public void unMove(Coordinate origin, Coordinate target) {
		turn.change();
		board.remove(target);
		board.put(origin, turn.take());
	}
}

package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

public class Game {

	private Board board;

	private Turn turn;

	public Game(boolean centered) {
		turn = new Turn();
		if (!centered) {
			board = new Board();
		} else {
			board = new CenteredBoard(turn.notTake());
		}
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

	public GameMemento createMemento() {
		GameMemento gameMemento = new GameMemento(turn.take());
		for (int i = 0; i < Board.DIMENSION; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				Coordinate coordinate = new Coordinate(i, j);
				for (Token token : Token.values()) {
					if (board.full(coordinate, token)) {
						gameMemento.set(coordinate, token);
					}
				}
			}
		}
		return gameMemento;
	}

	public void set(GameMemento gameMemento) {
		turn = new Turn(gameMemento.getTokenTurn());
		board = new Board();
		for (int i = 0; i < Board.DIMENSION; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				Coordinate coordinate = new Coordinate(i, j);
				board.put(coordinate, gameMemento.getTokenBoard(coordinate));
			}
		}
	}
}

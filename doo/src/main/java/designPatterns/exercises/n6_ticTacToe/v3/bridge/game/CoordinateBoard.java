package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.utils.IO;

public class CoordinateBoard implements ImplementationBoard {

	private Map<Token, Set<Coordinate>> playersCoordinates;

	public CoordinateBoard() {
		playersCoordinates = new HashMap<Token, Set<Coordinate>>();
		playersCoordinates.put(Token.X, new HashSet<Coordinate>());
		playersCoordinates.put(Token.O, new HashSet<Coordinate>());
	}

	@Override
	public void write() {
		for (int i = 0; i < Board.DIMENSION; i++) {
			for (int j = 0; j < Board.DIMENSION; j++) {
				IO.instance().write(
						this.getToken(new Coordinate(i, j)).getSymbol() + " ");
			}
			IO.instance().writeln();
		}
	}

	private Token getToken(Coordinate coordinate) {
		for (Token token : Token.values()) {
			if (token != Token.VOID && this.full(coordinate, token)) {
				return token;
			}
		}
		return Token.VOID;
	}

	@Override
	public boolean complete() {
		for (Set<Coordinate> playerCoordinates : playersCoordinates.values()) {
			if (playerCoordinates.size() < Board.DIMENSION) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean existTicTacToe() {
		for (Token token : Token.values()) {
			if (token != Token.VOID && this.existTicTacToe(token)) {
				return true;
			}
		}
		return false;
	}

	private boolean existTicTacToe(Token token) {
		Set<Coordinate> playerCoordinates = playersCoordinates.get(token);
		if (playerCoordinates.size() != Board.DIMENSION) {
			return false;
		}
		Coordinate[] coordinateArray = playerCoordinates
				.toArray(new Coordinate[0]);
		Direction direction = coordinateArray[0].direction(coordinateArray[1]);
		if (direction == Direction.NON_EXISTENT) {
			return false;
		}
		for (int i = 1; i < Board.DIMENSION - 1; i++) {
			if (coordinateArray[i].direction(coordinateArray[i + 1]) != direction) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean full(Coordinate coordinate, Token token) {
		Set<Coordinate> playerCoordinate = playersCoordinates.get(token);
		return playerCoordinate.contains(coordinate);
	}

	@Override
	public void put(Coordinate coordinate, Token token) {
		Set<Coordinate> playerCoordinate = playersCoordinates.get(token);
		playerCoordinate.add(coordinate);
	}
	
}

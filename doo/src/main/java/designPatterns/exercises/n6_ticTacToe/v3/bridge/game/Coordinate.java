package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.utils.IO;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.utils.LimitedIntDialog;

public class Coordinate {

	private int row;
	
	private int column;
	
	public Coordinate(){
		
	}
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public void read(String title) {
		assert title != null;
		IO.instance().writeln(title + " qué casilla?");
		row = LimitedIntDialog.instance().read("Fila?", 1, Board.DIMENSION)-1;
		column = LimitedIntDialog.instance().read("Columna?", 1, Board.DIMENSION)-1;
	}
	
	public Coordinate clone() {
		return new Coordinate(row, column);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [row=" + row + ", column=" + column + "]";
	}

	public Direction direction(Coordinate coordinate) {
		if (this.inRow(coordinate)){
			return Direction.HORIZONTAL;
		}
		if (this.inColumn(coordinate)){
			return Direction.VERTICAL;
		}
		if (this.inDiagonal() && coordinate.inDiagonal()){
			return Direction.DIAGONAL;
		}
		if (this.inInverse() && coordinate.inInverse()){
			return Direction.INVERSE;
		}
		return Direction.NON_EXISTENT;
	}

	private boolean inRow(Coordinate coordinate) {
		return row == coordinate.row;
	}
	
	private boolean inColumn(Coordinate coordinate) {
		return column == coordinate.column;
	}
	
	private boolean inDiagonal() {
		return row - column == 0;
	}
	
	private boolean inInverse() {
		return row + column == Board.DIMENSION -1;
	}
	
}

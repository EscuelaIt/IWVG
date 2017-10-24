package designPatterns.exercises.n6_ticTacToe.v2.memento.game;

import designPatterns.exercises.n6_ticTacToe.v2.memento.utils.IO;
import designPatterns.exercises.n6_ticTacToe.v2.memento.utils.LimitedIntDialog;

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
	
}

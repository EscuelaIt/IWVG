package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

public class GameMemento {

	private Token tokenTurn;
	
	private Token[][] tokensBoard;

	public GameMemento(Token tokenTurn) {
		this.tokenTurn = tokenTurn;
		tokensBoard = new Token[Board.DIMENSION][Board.DIMENSION];
	}

	public void set(Coordinate coordinate, Token token) {
		tokensBoard[coordinate.getRow()][coordinate.getColumn()] = token;
	}
	
	Token getTokenTurn(){
		return tokenTurn;
	}
	
	Token getTokenBoard(Coordinate coordinate){
		return tokensBoard[coordinate.getRow()][coordinate.getColumn()];
	}

	@Override
	public String toString() {
		String toString = "GameMemento [\ntokenTurn=" + tokenTurn + "\ntokensBoard=\n";
		for(int i=0; i<tokensBoard.length; i++){
			for(int j=0; j<tokensBoard[i].length; j++){
				toString += tokensBoard[i][j] + " ";
			}
			toString += "\n";
		}
		return toString + "]";
	}
		
}

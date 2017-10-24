package designPatterns.exercises.n6_ticTacToe.v3.bridge.menu;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.Coordinate;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.Game;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.MementoRegistry;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.utils.IO;

public class PutCommand extends UndoableCommand {

	private Coordinate coordinate;

	protected PutCommand(Game game, MementoRegistry mementoRegistry) {
		super("Poner ficha", game, mementoRegistry);
		coordinate = new Coordinate();
	}
	
	@Override
	public boolean isActive() {
		return !game.complete() && !game.existTicTacToe();
	}

	@Override
	public void execute() {
		boolean ok = false;
		do {
			coordinate.read("Coordenada para poner");
			ok = game.empty(coordinate);
			if (!ok) {
				IO.instance().writeln("Error!!! Esa coordenada está ocupada");
			}
		} while (!ok);
		game.put(coordinate);
		mementoRegistry.registry();
	}

	@Override
	public void undo() {
		game.unPut(coordinate);
	}
	
	@Override
	public void redo() {
		game.put(coordinate);		
	}

	@Override
	public String toString() {
		return "PutCommand [coordinate=" + coordinate + "]";
	}
	
}

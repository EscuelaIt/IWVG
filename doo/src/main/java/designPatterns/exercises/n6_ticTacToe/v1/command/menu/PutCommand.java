package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Coordinate;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;
import designPatterns.exercises.n6_ticTacToe.v1.command.utils.IO;

public class PutCommand extends UndoableCommand {

	private Coordinate coordinate;

	protected PutCommand(Game game, CommandRegistry commandRegistry) {
		super("Poner ficha", game, commandRegistry);
		coordinate = new Coordinate();
	}
	
	@Override
	public boolean isActive() {
		return !game.complete();
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
		commandRegistry.registry(this.clone());
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
	public UndoableCommand clone() {
		PutCommand putCommand = new PutCommand(game, commandRegistry);
		putCommand.coordinate = coordinate.clone();
		return putCommand;
	}

	@Override
	public String toString() {
		return "PutCommand [coordinate=" + coordinate + "]";
	}
	
}

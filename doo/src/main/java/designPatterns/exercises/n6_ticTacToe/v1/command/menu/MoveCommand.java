package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Coordinate;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;
import designPatterns.exercises.n6_ticTacToe.v1.command.utils.IO;

public class MoveCommand extends UndoableCommand {

	private Coordinate origin;

	private Coordinate target;

	protected MoveCommand(Game game, CommandRegistry commandRegistry) {
		super("Mover ficha", game, commandRegistry);
		origin = new Coordinate();
		target = new Coordinate();
	}
	
	@Override
	public boolean isActive() {
		return game.complete() && !game.existTicTacToe();
	}

	@Override
	public void execute() {
		IO io = IO.instance();
		boolean ok = false;
		do {
			origin.read("Coordenada para quitar");
			ok = game.full(origin);
			if (!ok) {
				io.writeln("Error!!! Esa coordenada no está ocupada por una de tus fichas");
			}
		} while (!ok);
		ok = false;
		do {
			target.read("Coordenada para poner");
			ok = game.empty(target);
			if (!ok) {
				io.writeln("Error!!! Esa coordenada está ocupada");
			} else {
				ok = !origin.equals(target);
				if (!ok) {
					io.writeln("Error!!! No se puede poner de donde se quita");
				}
			}
		} while (!ok);
		game.move(origin, target);
		commandRegistry.registry(this.clone());
	}

	@Override
	public void undo() {
		game.unMove(origin, target);		
	}
	
	@Override
	public void redo() {
		game.move(origin, target);		
	}
	
	public UndoableCommand clone() {
		MoveCommand moveCommand = new MoveCommand(game, commandRegistry);
		moveCommand.origin = origin.clone();
		moveCommand.target = target.clone();
		return moveCommand;
	}
	
	@Override
	public String toString() {
		return "MoveCommand [origin=" + origin + ", target=" + target + "]";
	}


	
}

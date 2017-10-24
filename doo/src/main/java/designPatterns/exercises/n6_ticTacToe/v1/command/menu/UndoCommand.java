package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;

public class UndoCommand extends Command {

	protected UndoCommand(Game game, CommandRegistry commandRegistry) {
		super("Deshacer", game, commandRegistry);		
	}

	@Override
	public void execute() {
		
		commandRegistry.undo();
	}

	@Override
	public boolean isActive() {
		return commandRegistry.undoable();
	}

}
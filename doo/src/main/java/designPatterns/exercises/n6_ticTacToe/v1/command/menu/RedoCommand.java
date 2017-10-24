package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;

public class RedoCommand extends Command {

	protected RedoCommand(Game game, CommandRegistry commandRegistry) {
		super("Rehacer", game, commandRegistry);		
	}

	@Override
	public void execute() {
		commandRegistry.redo();
	}

	@Override
	public boolean isActive() {
		return commandRegistry.redoable();
	}

}

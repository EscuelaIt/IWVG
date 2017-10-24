package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;

public abstract class UndoableCommand extends Command {
	
	protected UndoableCommand(String title, Game game, CommandRegistry commandRegistry) {
		super(title, game, commandRegistry);
	}

	public abstract void undo();
	
	public abstract void redo();
	
	public abstract UndoableCommand clone();
	
}

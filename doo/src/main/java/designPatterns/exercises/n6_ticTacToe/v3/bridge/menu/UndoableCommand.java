package designPatterns.exercises.n6_ticTacToe.v3.bridge.menu;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.Game;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.MementoRegistry;

public abstract class UndoableCommand extends Command {
	
	protected UndoableCommand(String title, Game game, MementoRegistry mementoRegistry) {
		super(title, game, mementoRegistry);
	}

	public abstract void undo();
	
	public abstract void redo();
		
}

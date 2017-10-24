package designPatterns.exercises.n6_ticTacToe.v3.bridge.menu;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.Game;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.MementoRegistry;

public class UndoCommand extends Command {

	protected UndoCommand(Game game, MementoRegistry mementoRegistry) {
		super("Deshacer", game, mementoRegistry);		
	}

	@Override
	public void execute() {
		mementoRegistry.undo(game);
	}

	@Override
	public boolean isActive() {
		return mementoRegistry.undoable();
	}

}
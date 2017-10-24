package designPatterns.exercises.n6_ticTacToe.v3.bridge.menu;

import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.Game;
import designPatterns.exercises.n6_ticTacToe.v3.bridge.game.MementoRegistry;

public class RedoCommand extends Command {

	protected RedoCommand(Game game, MementoRegistry mementoRegistry) {
		super("Rehacer", game, mementoRegistry);		
	}

	@Override
	public void execute() {
		mementoRegistry.redo(game);
	}

	@Override
	public boolean isActive() {
		return mementoRegistry.redoable();
	}

}

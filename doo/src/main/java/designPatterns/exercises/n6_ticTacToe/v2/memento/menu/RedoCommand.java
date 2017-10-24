package designPatterns.exercises.n6_ticTacToe.v2.memento.menu;

import designPatterns.exercises.n6_ticTacToe.v2.memento.game.Game;
import designPatterns.exercises.n6_ticTacToe.v2.memento.game.MementoRegistry;

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

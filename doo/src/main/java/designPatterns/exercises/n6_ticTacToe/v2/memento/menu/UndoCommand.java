package designPatterns.exercises.n6_ticTacToe.v2.memento.menu;

import designPatterns.exercises.n6_ticTacToe.v2.memento.game.Game;
import designPatterns.exercises.n6_ticTacToe.v2.memento.game.MementoRegistry;

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
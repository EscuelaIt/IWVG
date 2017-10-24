package designPatterns.exercises.n6_ticTacToe.v2.memento.menu;

import designPatterns.exercises.n6_ticTacToe.v2.memento.game.Game;
import designPatterns.exercises.n6_ticTacToe.v2.memento.game.MementoRegistry;

public abstract class Command {

	private String title;
	
	protected Game game;
	
	protected MementoRegistry mementoRegistry;		
	
	protected Command(String title, Game game, MementoRegistry mementoRegistry) {
		this.title = title;
		this.game = game;
		this.mementoRegistry = mementoRegistry;
	}
	
	public String getTitle() {
		return title;
	}
	
	public abstract void execute();
	
	public abstract boolean isActive();

}

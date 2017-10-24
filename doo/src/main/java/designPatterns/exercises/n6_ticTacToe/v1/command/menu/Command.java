package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;

public abstract class Command {

	private String title;
	
	protected Game game;
	
	protected CommandRegistry commandRegistry;		
	
	protected Command(String title, Game game, CommandRegistry commandRegistry) {
		this.title = title;
		this.game = game;
		this.commandRegistry = commandRegistry;
	}
	
	public String getTitle() {
		return title;
	}
	
	public abstract void execute();
	
	public abstract boolean isActive();

}

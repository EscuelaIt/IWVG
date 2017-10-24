package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

import java.util.ArrayList;
import java.util.List;

import designPatterns.exercises.n6_ticTacToe.v1.command.game.CommandRegistry;
import designPatterns.exercises.n6_ticTacToe.v1.command.game.Game;
import designPatterns.exercises.n6_ticTacToe.v1.command.utils.IO;
import designPatterns.exercises.n6_ticTacToe.v1.command.utils.LimitedIntDialog;

public class Menu {

	private Game game;

	private List<Command> allCommandList;
	
	private ExitCommand exitCommand;
	
	private List<Command> actualCommandList;

	private CommandRegistry commandRegistry;

	public Menu(Game game) {
		this.game = game;
		actualCommandList = new ArrayList<Command>();
		commandRegistry = new CommandRegistry();
		allCommandList = new ArrayList<Command>();
		allCommandList.add(new PutCommand(game, commandRegistry));
		allCommandList.add(new MoveCommand(game, commandRegistry));
		allCommandList.add(new UndoCommand(game, commandRegistry));
		allCommandList.add(new RedoCommand(game, commandRegistry));
		exitCommand = new ExitCommand();
		allCommandList.add(exitCommand);
	}

	private void setActualCommands() {
		actualCommandList.clear();
		for(Command command: allCommandList){
			if (command.isActive()){
				actualCommandList.add(command);
			}
		} 
	}

	public void execute() {
		do {
			this.setActualCommands();
			game.write();
			this.write();
			int option = this.getOption();
			actualCommandList.get(option).execute();
		} while (!this.isClosed());
	}

	private void write() {
		IO.instance().writeln();
		IO.instance().writeln();
		IO.instance().writeln("---------------------");
		for (int i = 0; i < actualCommandList.size(); i++) {
			IO.instance().writeln(
					(i + 1) + ". " + actualCommandList.get(i).getTitle());
		}
	}

	private int getOption() {
		return LimitedIntDialog.instance()
				.read("Opción", 1, actualCommandList.size()) - 1;
	}

	private boolean isClosed() {
		return exitCommand.closed();
	}

}

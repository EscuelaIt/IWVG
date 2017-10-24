package designPatterns.exercises.n6_ticTacToe.v1.command.game;

import java.util.ArrayList;
import java.util.List;

import designPatterns.exercises.n6_ticTacToe.v1.command.menu.UndoableCommand;

public class CommandRegistry {

	private List<UndoableCommand> commandList;

	private int firstPrevious;

	public CommandRegistry() {
		commandList = new ArrayList<UndoableCommand>();
		firstPrevious = 0;
	}

	public void registry(UndoableCommand undoableCommand) {
		for(int i=0; i<firstPrevious; i++){
			commandList.remove(0);
		}
		firstPrevious = 0;
		commandList.add(firstPrevious, undoableCommand);
	}

	public void undo() {
		commandList.get(firstPrevious).undo();
		firstPrevious++;
	}

	public void redo() {
		firstPrevious--;
		commandList.get(firstPrevious).redo();
	}
	
	public boolean undoable() {
		return firstPrevious < commandList.size();
	}

	public boolean redoable() {
		return firstPrevious > 0;
	}

	@Override
	public String toString() {
		String result = "CommandRegistry [\nposition=" + firstPrevious
				+ "\ncommands=";
		for (UndoableCommand command : commandList) {
			result += "\n" + command.toString();
		}
		return result + "]";
	}

}

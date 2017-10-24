package designPatterns.exercises.n6_ticTacToe.v3.bridge.game;

import java.util.ArrayList;
import java.util.List;

public class MementoRegistry {

	private Game game;

	private List<GameMemento> mementoList;
	
	private int firstPrevious;

	public MementoRegistry(Game game) {
		this.game = game;
		mementoList = new ArrayList<GameMemento>();
		mementoList.add(firstPrevious, game.createMemento());
		firstPrevious = 0;
	}

	public void registry() {
		for(int i=0; i<firstPrevious; i++){
			mementoList.remove(0);
		}
		firstPrevious = 0;
		mementoList.add(firstPrevious, game.createMemento());
	}

	public void undo(Game game) {
		firstPrevious++;
		game.set(mementoList.get(firstPrevious));
	}

	public void redo(Game game) {
		firstPrevious--;
		game.set(mementoList.get(firstPrevious));
	}
	
	public boolean undoable() {
		return firstPrevious < mementoList.size()-1;
	}

	public boolean redoable() {
		return firstPrevious >= 1;
	}

	@Override
	public String toString() {
		String result = "CommandRegistry [\nposition=" + firstPrevious
				+ "\nmementos=";
		for (GameMemento gameMemento : mementoList) {
			result += "\n" + gameMemento.toString();
		}
		return result + "]";
	}

}

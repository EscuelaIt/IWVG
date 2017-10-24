package designPatterns.exercises.n6_ticTacToe.v1.command.menu;

class ExitCommand extends Command {

	private boolean closed;
	
	protected ExitCommand() {
		super("Salir", null, null);
		closed = false;
	}

	@Override
	public void execute() {
		closed = true;
	}

	public boolean closed() {
		return closed;
	}

	@Override
	public Command clone() {
		return this;
	}

	@Override
	public boolean isActive() {
		return true;
	}
	
}

package designPatterns.exercises.n1_io.v5.decorator;

public class UppercaseIO extends DecoratorIO {

	public UppercaseIO(IO io) {
		super(io);
	}

	@Override
	public String readString(String title) {
		return io.readString(title.toUpperCase());
	}

	@Override
	public int readInt(String title) {
		return io.readInt(title.toUpperCase());
	}

	@Override
	public char readChar(String title) {
		return io.readChar(title.toUpperCase());
	}

	@Override
	public void writeln() {
		io.writeln();
	}

	@Override
	public void write(String string) {
		io.write(string.toUpperCase());
	}

	@Override
	public void writeln(String string) {
		this.write(string);
		this.writeln();
	}

}

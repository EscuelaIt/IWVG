package designPatterns.exercises.n1_io.v5.decorator;

public class UnderlineIO extends DecoratorIO {

	public UnderlineIO(IO io) {
		super(io);
	}

	@Override
	public String readString(String title) {
		return io.readString(title);
	}

	@Override
	public int readInt(String title) {
		return io.readInt(title);
	}

	@Override
	public char readChar(String title) {
		return io.readChar(title);
	}

	@Override
	public void writeln() {
		io.writeln();
	}

	@Override
	public void write(String string) {
		io.write(string);
		this.writeln();
		for(int i=0; i<string.length(); i++){
			io.write("-");
		}
	}

	@Override
	public void writeln(String string) {
		this.write(string);
		io.writeln();
	}

}

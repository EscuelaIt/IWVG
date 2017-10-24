package designPatterns.exercises.n1_io.v5.decorator;

public class Client {

	public void exec(){
		// ...
		int code;
		int amount;
		IO io = IO.instance();
		// ...
		code = io.readInt("Introduzca el código: ");
		amount = io.readInt("Introduzca la cantidad: ");
		io.writeln("Código: " + code);
		io.writeln("Cantidad: " + amount);
		// ...
		io = new UppercaseIO(IO.instance());
		code = io.readInt("Introduzca el código: ");
		amount = io.readInt("Introduzca la cantidad: ");
		io.writeln("Código: " + code);
		io.writeln("Cantidad: " + amount);
		// ...
		io = new UnderlineIO(io);
		code = io.readInt("Introduzca el código: ");
		amount = io.readInt("Introduzca la cantidad: ");
		io.writeln("Código: " + code);
		io.writeln("Cantidad: " + amount);
		// ...
		io = IO.instance();
		code = io.readInt("Introduzca el código: ");
		amount = io.readInt("Introduzca la cantidad: ");
		io.writeln("Código: " + code);
		io.writeln("Cantidad: " + amount);
	}
	
	public static void main(String[] args) {
		new Client().exec();
	}
}

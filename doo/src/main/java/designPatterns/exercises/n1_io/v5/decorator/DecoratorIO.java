package designPatterns.exercises.n1_io.v5.decorator;

public abstract class DecoratorIO extends IO {

	protected IO io;
	
	protected DecoratorIO(IO io){
		this.io = io;
	}
	
}

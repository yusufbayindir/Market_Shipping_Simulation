package exceptions;

public class MassBoxOverflowException extends Exception {
	public static final int CODE=6;
	
	public MassBoxOverflowException() {
		super("A Mass Box cannot hold items more than its capacity. "+" Ex code: "+ CODE);
	}

	public MassBoxOverflowException(String message) {
		super(message);
	}


}

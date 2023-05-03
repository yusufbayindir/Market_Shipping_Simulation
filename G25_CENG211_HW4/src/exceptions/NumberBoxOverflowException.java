package exceptions;

public class NumberBoxOverflowException extends Exception {
	public static final int CODE=7;

	public NumberBoxOverflowException() {
		super("A Number Box cannot hold items more than its capacity. "+" Ex code: "+ CODE);
	}

	public NumberBoxOverflowException(String message) {
		super(message);
	}

}

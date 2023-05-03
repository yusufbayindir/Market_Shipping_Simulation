package exceptions;

public class ContainerOverflowException extends Exception {
	public static final int CODE=3;

	public ContainerOverflowException() {
		super("Container cannot hold items directly. "+" Ex code: "+ CODE);
	}

	public ContainerOverflowException(String message) {
		super(message);
	}

}

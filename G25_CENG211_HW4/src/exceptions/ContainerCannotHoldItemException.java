package exceptions;

public class ContainerCannotHoldItemException extends Exception {
	public static final int CODE=2;

	public ContainerCannotHoldItemException() {
		super("Container cannot hold items. "+" Ex code: "+ CODE);
	}

	public ContainerCannotHoldItemException(String message) {
		super(message);
		
	}

}

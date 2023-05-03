package exceptions;

public class ShippedEntityCannotUseAgainException extends Exception {
	public static final int CODE=9;

	public ShippedEntityCannotUseAgainException() {
		super("Shipped entity cannot be used again. "+" Ex code: "+ CODE);
	}

	public ShippedEntityCannotUseAgainException(String message) {
		super(message);
	}

}

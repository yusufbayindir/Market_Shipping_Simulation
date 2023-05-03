package exceptions;

public class UncountableItemMismatchException extends Exception {
	public static final int CODE=10;

	public UncountableItemMismatchException() {
		super("An uncountable item cannot be placed to a Number Box. "+" Ex code: "+ CODE);
	}

	public UncountableItemMismatchException(String message) {
		super(message);
	}



}

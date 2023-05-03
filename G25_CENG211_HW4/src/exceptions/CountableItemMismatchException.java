package exceptions;

public class CountableItemMismatchException extends Exception {
	public static final int CODE=4;

	public CountableItemMismatchException() {
		super("A countable item cannot be placed to a Mass Box. "+" Ex code: "+ CODE);
	}

	public CountableItemMismatchException(String message) {
		super(message);
	}

}

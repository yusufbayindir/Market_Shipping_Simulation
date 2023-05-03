package exceptions;

public class SameSerialNumberException extends Exception {
	public static final int CODE=8;

	public SameSerialNumberException() {
		super("An entity cannot be produced with the same serial number. "+" Ex code: "+ CODE);		
	}
	public SameSerialNumberException(String message) {
		super(message);
	}
}

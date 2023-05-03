package exceptions;

public class AlreadyBoxedException extends Exception {
	public static final int CODE=1;
	public AlreadyBoxedException() {
		super("This item is already boxed. "+" Ex code: "+ CODE);
	}

	public AlreadyBoxedException(String message) {
		super(message);
		
	}

}

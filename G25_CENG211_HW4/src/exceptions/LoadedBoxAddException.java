package exceptions;

public class LoadedBoxAddException extends Exception {
	public static final int CODE=5;
	public LoadedBoxAddException() {
		super("A loaded box cannot take any item in it. "+" Ex code: "+ CODE);
	}

	public LoadedBoxAddException(String message) {
		super(message);
	}


}

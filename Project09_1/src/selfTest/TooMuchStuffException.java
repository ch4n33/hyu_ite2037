package selfTest;

public class TooMuchStuffException extends Exception {

	private int inputNumber;
	
	public TooMuchStuffException(int i) {
		super("too much stuff!");
		inputNumber = i;
	}
	
	public TooMuchStuffException() {
		super("too much stuff");
	}
	
	public TooMuchStuffException(String s) {
		super(s);
	}
	
	public int getNumber() {
		return inputNumber;
	}
	
}

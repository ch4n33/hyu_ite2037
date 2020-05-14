package selfTest;

public class TooMuchStuffException extends Exception {

	private int inputNumber;
	
	public TooMuchStuffException(int i) {
		super("Too much stuff!");
		inputNumber = i;
	}
	
	public TooMuchStuffException() {
		super("Too much stuff!");
	}
	
	public TooMuchStuffException(String e) {
		super(e);
	}
	
	public int getNumber() {
		return inputNumber;
	}
	
}

package selfTest;

public class PowerFailureException extends Exception{

	public PowerFailureException() {
		super("Power Failure");
	}
	
	public PowerFailureException(String S) {
		super(S);
	}
	
}

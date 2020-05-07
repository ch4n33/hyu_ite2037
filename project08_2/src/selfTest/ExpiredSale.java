package selfTest;

public class ExpiredSale extends Sale {
	
	private double expired;
	
	public ExpiredSale() {
		super();
		setExpired(0);
	}
	
	public ExpiredSale(String theName, double thePrice, double theExpired) {
		super(theName, thePrice);
		setExpired(theExpired);
	}
	
	public void setExpired(double theExpired) {
		expired = theExpired;
	}
	
	public String toString() { return (getName() + " Price = $" + getPrice() + " Expired = " + expired + " left\n" + " Deliver Fee = $" + deliverFee()); }
	
	public double deliverFee() {
		if (this.expired >=10) {
			return 3;
		}else if (this.expired >= 3) {
			return 2;
		}else if (this.expired > 1){
			return 0;
		}else {
			System.out.println("Cannot deliver this.");
			return 0;
		}
	}
	
}

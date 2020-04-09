package selfTest;

public class DateFirstTryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFirstTry date1 = new DateFirstTry();
		DateFirstTry date2 = new DateFirstTry();
		
		/*Write the Code*/
		
		date1.month = "April";
		date1.day = 9;
		
		date2.month = "May";
		date2.day = 12;
		
		System.out.println("date1: " + date1.yellIfNewYear());
		System.out.println("date2: " + date2.yellIfNewYear());
		
	}

}

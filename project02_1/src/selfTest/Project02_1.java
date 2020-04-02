package selfTest;
import java.util.Scanner;//Import the library for using Scanner class

public class Project02_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner S = new Scanner(System.in);//Generate the Scanner class
		
		int n = 0;
		
		System.out.print("Enter the number: ");
		n = S.nextInt();

		if (n < 0) {
			System.out.println(n +" is less then 0");
		} else if (n < 100) {
			System.out.println(n +" is greater than or equal to 0 and less than 100");
		} else {
			System.out.println(n +" is greater than or equal to 100");
		}
		
	}

}

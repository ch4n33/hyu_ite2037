package selfTest;

public class Project02_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intVal1, intVal2;
		intVal1 = 1;
		int n;
		while(intVal1 < 6) {
			intVal2 = 5;
			while(intVal2 > 0) {
				n = intVal1 * intVal2;
				System.out.println(intVal1 + " multiplied by "+intVal2+" = "+n);
				intVal2--;
			}
			intVal1++;
		}
	}
}

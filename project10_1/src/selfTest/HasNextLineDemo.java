package selfTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HasNextLineDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		
		try {
			File inFile = new File("resource/BladeRunner.txt");
			File outFile = new File("resource/NumberedRunner.txt");
			FileInputStream inFileStream = new FileInputStream(inFile);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			inputStream = new Scanner(inFileStream);
			outputStream = new PrintWriter(outFileStream);
			for	(int i=1; inputStream.hasNextLine();i++) {
				outputStream.println("(" + i + ")" + inputStream.nextLine());
			}
			/* Input File Location Example: "resource\\BladeRunner.txt" */
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(0);
		}

		inputStream.close();
		outputStream.close();
	}

}

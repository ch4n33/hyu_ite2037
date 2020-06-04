package assignment03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;

public class ElectionSim {
	private String outputFile;
	private int population;
	private Candidate[] candidates;
	private Region[] regions;
	
	public ElectionSim(String inputFile, String outputFile) {
		this.outputFile = outputFile;

		try	{
			FileInputStream inFileStream = new FileInputStream (inputFile);
			Scanner inputStream = new Scanner(inFileStream);

			String temp=null;

			while(inputStream.hasNextLine()) {
				temp = inputStream.next();
				if (temp.equals("POPULATION")){
					this.population = inputStream.nextInt(); inputStream.nextLine();
				}
				if(temp.equals("CANDIDATES")) {
					this.candidates = new Candidate[inputStream.nextInt()];inputStream.nextLine();
					for	(int i=0; i<this.candidates.length; i++) {
						this.candidates[i] = new Candidate(inputStream.nextLine(), this.population);
					}
				}
				if (temp.equals("REGIONS")) {
					this.regions = new Region[inputStream.nextInt()];inputStream.hasNextLine();
					for (int i=0; i <this.regions.length; i++) {
						this.regions[i] = new Region(inputStream.next(), inputStream.nextInt(),
								inputStream.nextInt(), this.candidates);
					}

				}
			}
			inputStream.close();
		}catch(FileNotFoundException e) {
			System.out.println("input file not found");
		}
	}
	
	public void saveData() throws FileNotFoundException {
		Arrays.sort(this.candidates);
		FileOutputStream outFileStream = new FileOutputStream(this.outputFile);
		PrintWriter print = new PrintWriter(outFileStream);
		for	(Candidate C:this.candidates) {
			print.println(C.toString());//
			for	(Region R: this.regions) {
				print.println(R.getRegionName()+": " + C.toRegionString(R.getRegionNum()));
			}
			print.println("\n============================================");
		}
		print.close();
		
		
	}
	
	public void runSimulation() {
		try {
			for	(Region R :this.regions) {
				R.start();
			}
			for	(Region R :this.regions) {
				R.join();
			}
			try {
				this.saveData();
			} catch (FileNotFoundException e) {
				System.out.println("output file not found");
			}
		}catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

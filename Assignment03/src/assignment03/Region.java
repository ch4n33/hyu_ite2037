package assignment03;
import java.util.Random;

public class Region extends Thread{

	private Random random = new Random();
	private String regionName;			// The name of the region
	private int regionNum;			// The number of the region
	private int population;			// The population of the region
	private Candidate[] candidates;	// An array of the candidates of the election
	
	public Region(String regionName, int regionNum, int population, Candidate[] candidates) {
		this.candidates = candidates;
		this.population = population;
		this.regionName = regionName;
		this.regionNum  = regionNum;
	}
	
	public String getRegionName() {
		return this.regionName;
	}
	
	public int getRegionNum() {
		return this.regionNum;
	}
	
	public void generateVotes() {
		this.candidates[random.nextInt(this.candidates.length)].callAddVotes(this.regionNum);
	}
	
	public void run() {
		for	(int i=0; i< this.population; i++) {
			this.generateVotes();
		}
	}
}

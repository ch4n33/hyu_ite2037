package assignment03;

public class Candidate implements Comparable {
	private String name;
	private int numVotes = 0;
	private Vote[] votes;
	
	public Candidate(String name, int maxVotes) {
		this.name = name;
		this.votes = new Vote[maxVotes];
	}
	
	public String toString() {
		String temp = "------------Candidate------------\nName: ";
		temp += this.name+"\nTotal Votes: ";
		temp += this.numVotes;
		return temp;
	}
	
	public int toRegionString(int regionNum) {
		int temp =0;
		for	(Vote V:this.votes) {
			if (V == null) {
				continue;
			}
			if (V.regionNum == regionNum) {
				temp++;
			}
		}
		return temp;
	}
	public String getName() {return this.name;}
	public synchronized void callAddVotes(int regionNum) {
		new Vote().addVote(regionNum);
	}
	
	@Override public int compareTo(Object obj) {
		if(obj == null) {throw new NullPointerException("Object is null");}
		if(obj.getClass()!= this.getClass()) {throw new ClassCastException("Object not of the same type");}
		Candidate C = (Candidate)obj; return this.numVotes - C.numVotes;
	}
	
	private class Vote {

		private int regionNum;
		public Vote() {
			
		}
		public Vote(int regionNum) {
			this.regionNum = regionNum;
		}
		
		public synchronized void addVote(int regionNum) {
			votes[numVotes] = new Vote(regionNum);
			numVotes++;
		}
	}
}

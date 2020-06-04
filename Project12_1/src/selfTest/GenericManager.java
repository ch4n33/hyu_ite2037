 package selfTest;

import java.util.ArrayList;
import java.util.Collections;

public class GenericManager <T extends Comparable>{
	private ArrayList<T> cList;

	public GenericManager() {
		this.cList = new ArrayList<T>();
	}
	
	public void add(T a) {
		this.cList.add(a);
	}
	
	public void sort() {
		Collections.sort(cList);
	}
	
	public String find(T a) {
		String temp = "";
		for(T t:this.cList) {
			if (t.equals(a))
				temp += t.toString();
		}
		return temp;
	}
	
	public String toString() {
		String temp ="";
		for (T t :this.cList) {
			temp += t.toString();
		}
		return temp;
	}
}

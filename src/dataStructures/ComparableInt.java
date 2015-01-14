package dataStructures;

public class ComparableInt implements Comparable<Integer> {
	public int value;
	
	public ComparableInt(int value) {
		this.value = value;
	}

	public int compareTo(Integer arg0) {
		return arg0 - this.value;
	}

}

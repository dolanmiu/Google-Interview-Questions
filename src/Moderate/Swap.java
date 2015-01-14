package Moderate;

public class Swap {
	public static int[] swap(int first, int second) {
		second = first + second;
		first = Math.abs(first - second);
		second = second - first;
		
		return new int[] { first, second };
	}

	public static void main(String[] args) {
		int[] df = swap(6, 14);
		System.out.println(df[0] + " " + df[1]);
	}
}

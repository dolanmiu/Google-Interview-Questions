package dynamicProgramming;

public class CurrenyPermutations {
	public static int calculateMoney(int total) {
		if (total == 0) {
			return 1;
		}

		int permutations = calculateMoney(total - 1);

		if (total % 5 == 0 || total % 10 == 0 || total % 25 == 0) {
			permutations++;
		}

		return permutations;

	}
	
	
	public static void main(String[] args) {
		System.out.println(calculateMoney(50));
	}
}

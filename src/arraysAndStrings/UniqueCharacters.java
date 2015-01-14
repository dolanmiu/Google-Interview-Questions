package arraysAndStrings;
import java.util.HashMap;

public class UniqueCharacters {

	public static boolean checkIfUnique(String input) {
		HashMap<Character, Integer> characterList = new HashMap<Character, Integer>();
		
		for (int i = 0 ; i < input.length(); i++) {
			char c = input.charAt(i);
			int n = 0;
			if (characterList.containsKey(c)) {
				n = characterList.get(c);
			}
			n++;
			characterList.put(c, n);

		}

		for (Integer i : characterList.values()) {
			if (i > 1) return false;
		}
		
		return true;

	}
	
	/*public static void main(String[] args) {
		boolean result = checkIfUnique("heqwrdlo");
		System.out.println(result);
	}*/
}

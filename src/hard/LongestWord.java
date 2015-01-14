package hard;

import java.util.HashMap;

public class LongestWord {
	public static String findWords(String[] array) {
		String currentString = null;
		
		HashMap<String, Boolean> strings = convertArrayToHashMap(array);
		
		for (int i = 0; i < array.length; i++) {
			String sub = null;
			int head = 0;
			int end;

			for (end = 0; end < array[i].length(); end++) {

				sub = array[i].substring(head, end);
				Boolean isExists = strings.get(sub);

				if (isExists != null) {
					if (currentString == null || array[i].length() > currentString.length()) {
						currentString = array[i];
						
					}
					head = end;
				}
			}

		}
		return currentString;
	}

	public static HashMap<String, Boolean> convertArrayToHashMap(String[] array) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		for (String string : array) {
			map.put(string, true);
		}

		return map;
	}

	public static void main(String[] args) {
		String[] array = new String[] { "cat", "banana", "dog", "nana", "walk", "walker", "dogwalker" }; 
		String biggestWord = findWords(array);
		System.out.println(biggestWord);
	}
}

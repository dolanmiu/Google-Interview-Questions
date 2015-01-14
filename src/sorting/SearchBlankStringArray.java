package sorting;

public class SearchBlankStringArray {
	public static void recursiveSearchBlankArray(String[] inputArray, String searchString) {
		int middle = inputArray.length / 2 + 1;
		
		String leftString = lookLeft(inputString, middle);
		int compareInt = leftString.compareTo(searchString)
		if (compareInt > 1) {
			recursiveSearchBlankArray(inputSArray.subString(, searchString);
		} else if (compareInt < 1) {
			recursiveSearchBlankArray(inputSArray, searchString);
		} else {
			
		}

		
		recursiveSearchBlankArray(inputString
	}

	public static String lookLeft(String[] inputString, int start) {
		for (int i = start; i > 0; i--) {
			if (!inputString[i].equals("")) {
				return inputString[i];
			}
		}
		return null;
	}

	public static String lookRight(String[] inputString, int start) {
		for (int i = start; i > inputString.length; i++) {
			if (!inputString[i].equals("")) {
				return inputString[i];
			}
		}
		return null;
	}
}

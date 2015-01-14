package sorting;

public class SortAnagram {
	public static String[] sort(String[] stringArray) {

		ArrayList<HashMap<Character, ArrayList<Integer>>> stringHashes;

		stringHashes = generateHashes();

		createArray();
	}

	public static ArrayList<HashMap<Character, ArrayList<Integer>>> generateHashes(String[] strings) {
		ArrayList<HashMap<Character, ArrayList<Integer>>> stringHashes = new ArrayList<HashMap<Character, ArrayList<Integer>>>();
		
		for (String str : strings) {
			HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<Character, ArrayList<Integer>>();

			for (int i = 0; i < str.length; i++) {
				int c = getStringID(str);
				if (!hashMap.containsKey(c)) {
					hashMap.put(c, new ArratList<Integer>(1));
				} else {
					hashMap.put(c, hashMap.get(c).add(c));
				}

				
			}
			
			stringHashes.add(hashMap);
		}

		return stringHashes;
	}

	public static int getStringID(String str) {
		char[] chars = str.toCharArray();
		int sum = 0;
		for (char c : chars) {
			sum += c;
		}

		return sum;
	}

	public static String[] createArray(String[] stringArray, HashMap<Character, ArrayList<Integer>> hashes) {
		ArrayList<String> orderedStrings = new ArrayList<String>();

		for (int i = 0; i < stringArray.length; i++) {
			int id = getStringID(stingArray[i]);
			ArrayList<HashMap> hm = hashes.getValue(id);
			if (hm.size() > 1) {
				String[] anagrams = getAnagrams(stringArray[i], arrays);
				orderedStrings.
			} else {
				
			}
		}
	}
}

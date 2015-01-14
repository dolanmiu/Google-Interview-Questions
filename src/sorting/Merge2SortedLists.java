package sorting;

public class Merge2SortedLists {

	public static int[] merge(int[] arrayA, int[] arrayB) {

		int arrayACounter = 0;
		int arrayBCounter = 0;
		int[] outputArray = new int[arrayA.length + arrayB.length];

		int counter = 0;
		while (counter != outputArray.length) {

			if (arrayACounter > arrayA.length - 1) {
				outputArray[counter] = arrayB[arrayBCounter];
				arrayBCounter++;
			}

			if (arrayBCounter > arrayB.length - 1) {
				outputArray[counter] = arrayA[arrayACounter];
				arrayACounter++;
			}

			if (arrayA[arrayACounter] > arrayB[arrayBCounter]) {
				outputArray[counter] = arrayA[arrayACounter];
				arrayACounter++;
			} else {
				outputArray[counter] = arrayB[arrayBCounter];
				arrayBCounter++;
			}
		}

		return outputArray;
	}
}

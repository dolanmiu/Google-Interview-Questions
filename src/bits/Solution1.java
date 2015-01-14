package bits;

public class Solution1 {
	
	public static void main(String[] args) {
		int[] input = new int[] { 1, 1, 0, 1, 0, 0, 1, 1};
		System.out.println(solution(input));
	}
	
	public static int solution(int[] A) {
        boolean flipped = false;
        int adjecent = 0;
        for (int i = 0; i < A.length; i++) {
            boolean toFlip = flippable(A, i);
            
            if (toFlip && !flipped) {
                adjecent++;
                flipped = true;
            }
            
            adjecent = adjecent + checkAdjecent(A, i);

        }
        
        return adjecent;
    }
    
    private static boolean flippable(int[] inputArray, int index) {
        if (index == 0 || index == inputArray.length - 1) {
            return false;
        }
        
        if (inputArray[index-1] == inputArray[index+1]) {
            return true;
        } else {
            return false;
        }
    }
    
    private static int checkAdjecent(int[] inputArray, int index) {
        
        if (index % 2 != 0) return 0;
        int adj = 0;
        
        if (inputArray[index] == inputArray[index+1]) {
            adj++;
        }
        
        if (index != 0) { 
            if (inputArray[index] == inputArray[index-1]) {
                adj++;
            }
        }
        return adj;
    }
}


package bits;

class Solution12 {
    public int solution(int[] A) {
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
    
    private boolean flippable(int[] inputArray, int index) {
        if (index == 0 || index == inputArray.length - 1) {
            return false;
        }
        
        if (inputArray[index-1] == inputArray[index+1]) {
            return true;
        } else {
            return false;
        }
    }
    
    private int checkAdjecent(int[] inputArray, int index) {
        if (index == 0 || index == inputArray.length - 1) {
            return 0;
        }
        
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

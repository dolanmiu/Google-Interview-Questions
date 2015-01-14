package bits;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int binaryLength = binaryString.length();
        
        Queue<Integer> queue = convertStringToBinaryQueue(binaryString);
        return iterativeRightShiftChecker(queue, binaryLength);
    }
    
    private static Queue<Integer> convertStringToBinaryQueue(String input) {
        char[] binaryCharArray = input.toCharArray();
        binaryCharArray = Arrays.copyOf(binaryCharArray,30);
        return charArrayToQueue(binaryCharArray);
    }
    
    private static Queue<Integer> charArrayToQueue(char[] charArray) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = charArray.length - 1; i >= 0; i--) {
            queue.add((Integer)Character.getNumericValue(charArray[i]));
        }
        return queue;
    }
    
    private static int iterativeRightShiftChecker(Queue<Integer> queue, int sizeOfBinary) {
        Integer currentLargest = queueToInt(queue);
        int count = 0;
        
        for (; count < sizeOfBinary; count++) {
            Integer endBit = queue.poll();
            queue.add(endBit);
            Integer currentInt = queueToInt(queue);
            if (currentInt > currentLargest) {
                currentLargest = currentInt;
            }
        }
        return count;
    }
    
    private static Integer queueToInt(Queue<Integer> queue) {
        Object[] intArray = queue.toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]);
        }
        return Integer.parseInt(sb.toString(), 2);
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(9736));
    }
}

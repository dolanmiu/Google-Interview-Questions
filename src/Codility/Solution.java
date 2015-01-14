package Codility;

//you can also use imports, for example:
//import java.math.*;

//you can use System.out.println for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static void main(String[] args) {
		solution(6, 7, 3, new int[] { 1, 3 }, new int[] { 1, 5 });
		//solution(14, 30, 6, new int[] { 1, 3, 2, 6, 4 }, new int[] { 2, 6, 9 });
		//solution(11, 12, 1, new int[] { 3, 5, 8, 10 }, new int[] { 2, 5, 8, 11 });
		//solution(12, 11, 6, new int[] { 5, 7 }, new int[] { 3, 8 });
	}

 public static int solution(int X, int Y, int K, int[] A, int[] B) {
     // write your code in Java SE 8
     Point bottomLeftPoint = convertNumberToLeftPoint(K, A, B);
     Point[] box = findBoxFromBottomLeftPoint(bottomLeftPoint, X, Y, A, B);
     int area = findArea(box[0], box[1], box[2], box[3]);
     System.out.println(area);
     return area;
 }
 
 private static Point convertNumberToLeftPoint(int cakeSlice, int[] A, int[] B) {
     cakeSlice = cakeSlice - 1; //indexing starts at one
     int aSlices = A.length;
     int bSlices = B.length;
     int maxSlices = (aSlices + 1) * (bSlices + 1);
     
     if (cakeSlice > maxSlices) throw new RuntimeException("Too much cake!");
     if (cakeSlice < 0) throw new RuntimeException("Invalid cake number");
     
     int column;
     
     if (cakeSlice == 0) {
    	 column = 1;
     } else {
    	 column = cakeSlice % aSlices;
         if (column == 0) column = A.length;
     }
     int rowNumber = (int)Math.ceil(((cakeSlice + 1)/ (aSlices + 1))) + 1;
     int row = (bSlices + 1) - rowNumber;
     
     return new Point(A[column - 1], B[row - 1]);
 }
 
 private static Point[] findBoxFromBottomLeftPoint(Point bottomLeft, int X, int Y, int[] A, int[] B) {
     int topBValue = findNextValueInArray(B, bottomLeft.y);
     int topAValue = findNextValueInArray(A, bottomLeft.x);
     
     if (topBValue == -1) topBValue = Y;
     if (topAValue == -1) topAValue = X;
     
     Point topLeft = new Point(bottomLeft.x, topBValue);
     Point bottomRight = new Point(topAValue, bottomLeft.y);
     Point topRight = new Point(topAValue, topBValue);
     
     return new Point[] { bottomLeft, topLeft, topRight, bottomRight }; //clockwise from bottomLeft;
 }
 
 // This is so that we don't assume the array given is in sorted order. I could've alternatively sorted the list before hand. 
 // But I wanted to focus on the core algorithm task, not deviate into a sorting algorithm. Maybe in another implementation.
 private static int findNextValueInArray(int[] array, int currentNumber) {
     int smallestInt = Integer.MAX_VALUE;
     int largestNumber = Integer.MIN_VALUE;
     for (int number : array) {
         if (number > currentNumber && currentNumber < smallestInt) {
             smallestInt = number;
         }
         
         if (number > largestNumber) largestNumber = number;
     }
     
     //In the past I have had trouble equating Integer.MAX_VALUE, so I am using this approach
     if (smallestInt > largestNumber) {
         //Means the currentNumber is the largest in the list.
         return -1; 
     } else {
         return smallestInt;
     }
 }
 
 private static int findArea(Point bottomLeft, Point topLeft, Point topRight, Point bottomRight) {
     int height = Math.abs(topLeft.y - bottomLeft.y);
     int width = Math.abs(bottomRight.x - bottomLeft.x);
     
     return height * width;
 }
 
}

class Point {
 public int x;
 public int y;
 
 public Point(int x, int y) {
     this.x = x;
     this.y = y;
 }
 
 public Point() {
 }
}


package treesAndGraphs;

import java.util.Arrays;

public class ArrayToBalancedTree {

	public static void main(String[] args) {
		sortedArrayToBinarySearchTree(new int[3]);
	}
public static Node sortedArrayToBinarySearchTree(int[] inputArray) {
	Node root = new Node();
	recursiveAddToTree(inputArray, root);
	return root;
}

public static Node recursiveAddToTree(int[] inputArray, Node relativeRoot) {
	Node currentNode = new Node();
	int midPoint = (int)Math.ceil(inputArray.length / 2) - 1;
	currentNode.setValue(inputArray[midPoint]);

	if (inputArray.length == 1) {
		return currentNode;
	}

	if (midPoint != 0) {
		int[] leftArray = Arrays.copyOfRange(inputArray, 0, midPoint - 1);
		Node leftNode = recursiveAddToTree(leftArray, currentNode);
		currentNode.left = leftNode;
	}
	
	int[] rightArray = Arrays.copyOfRange(inputArray, midPoint + 1, inputArray.length - 1);
	Node rightNode = recursiveAddToTree(rightArray, currentNode);
	currentNode.right = rightNode;
	
	return currentNode;
}
}

package linkedLists;

import dataStructures.LinearNode;

public class RemoveElementFromMiddle {
	public static <T> void removeElementFromMiddle(LinearNode<T> firstNode) {
		int listCount = 0;
		LinearNode<T> currentNode = firstNode;
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			listCount++;
		}
		
		int halfListCount = listCount / 2;
		
		currentNode = firstNode;
		LinearNode<T> previousNode = null;

		for (int i = 0; i < halfListCount; i++) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}

		previousNode.setNext(currentNode.getNext());
	}
	
	public static void main(String[] args) {

		LinearNode<Integer> firstnode = new LinearNode<Integer>(1);
		LinearNode<Integer> currentNode = firstnode;

		currentNode.setNext(new LinearNode<Integer>(2));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(3));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(4));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(5));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(6));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(7));
		currentNode = currentNode.getNext();

		removeElementFromMiddle(firstnode);

		currentNode = firstnode;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}
}

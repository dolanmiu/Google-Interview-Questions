package linkedLists;

import dataStructures.LinearNode;

public class KthNodeFromEnd {
	public static <T> LinearNode<T> getNodeAtKthFromLast(LinearNode<T> firstNode, int indexFromLast) {
		LinearNode<T> currentNode = firstNode;
		LinearNode<T> nextNode = null;
		LinearNode<T> previousNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);

			previousNode = currentNode;
			currentNode = nextNode;
		}

		currentNode = previousNode;

		for (int i = 0; i < indexFromLast; i++) {
			currentNode = currentNode.getNext();
		}

		return currentNode;

	}
	
	public static void main(String[] args) {
		LinearNode<Integer> firstnode = new LinearNode<Integer>(1);
		LinearNode<Integer> currentNode = firstnode;

		currentNode.setNext(new LinearNode<Integer>(1));
		currentNode = currentNode.getNext();

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

		LinearNode<Integer> node = getNodeAtKthFromLast(firstnode, 5);

		System.out.println(node.toString());
	}
}

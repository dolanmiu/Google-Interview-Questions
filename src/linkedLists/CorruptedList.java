package linkedLists;

import java.util.HashMap;

import dataStructures.LinearNode;

public class CorruptedList {
	public static <T> LinearNode<T> getRepeatedNode(LinearNode<T> firstNode) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		LinearNode<T> currentNode = firstNode;
		while (!isInMap(map, currentNode.toString())) {

			if (!map.containsKey(currentNode)) map.put(currentNode.toString(), true);

			currentNode = currentNode.getNext();

		}

		return currentNode;
	}

	public static <T> boolean isInMap(HashMap<String, Boolean> map, String node) {
		if (map.containsKey(node)) {
			return true;
		} else {
			return false;
		}

	}
	
	public static void main(String[] args) {

		LinearNode<Integer> firstnode = new LinearNode<Integer>(1);
		LinearNode<Integer> currentNode = firstnode;
		LinearNode<Integer> destinationNode;

		currentNode.setNext(new LinearNode<Integer>(2));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(3));
		destinationNode = currentNode;
		currentNode = currentNode.getNext();
		
		currentNode.setNext(new LinearNode<Integer>(4));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(5));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(6));
		currentNode = currentNode.getNext();

		currentNode.setNext(destinationNode);

		currentNode = getRepeatedNode(firstnode);

		System.out.println(currentNode.toString());
	}
}

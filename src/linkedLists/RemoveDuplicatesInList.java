package linkedLists;

import java.util.LinkedList;

import dataStructures.LinearNode;

public class RemoveDuplicatesInList {
	public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		/*
		 * LinkedList<Integer> list = new LinkedList<Integer>(); list.add(1);
		 * list.add(2); list.add(2); list.add(3); list.add(3); list.add(4);
		 * removeDuplicates(list); System.out.println(list.toString());
		 */

		LinearNode<Integer> firstnode = new LinearNode<Integer>(1);
		LinearNode<Integer> currentNode = firstnode;

		currentNode.setNext(new LinearNode<Integer>(1));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(2));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(2));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(3));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(3));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(4));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(4));
		currentNode = currentNode.getNext();

		removeDuplicates(firstnode);

		currentNode = firstnode;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}

	public static LinearNode<Integer> removeDuplicates(
			LinearNode<Integer> firstNode) {
		LinearNode<Integer> currentNode = firstNode;

		while (currentNode.getNext() != null) {
			removeDuplicatesAhead(currentNode);
			
			currentNode = currentNode.getNext();
			if (currentNode == null) break;
		}
		return firstNode;
	}

	public static void removeDuplicatesAhead(LinearNode<Integer> node) {
		LinearNode<Integer> currentNode = node;
		while (currentNode.getNext() != null) {
			LinearNode<Integer> nextNode = currentNode.getNext();
			if (nextNode.getElement().equals(node.getElement())) {
				if (nextNode.getNext() == null) {
					currentNode.setNext(null);
				} else {
					currentNode.setNext(nextNode.getNext());
				}
			}
			if (currentNode.getNext() == null) break;
			currentNode = currentNode.getNext();
		}

	}
}

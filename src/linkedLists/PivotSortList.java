package linkedLists;

import dataStructures.ComparableInt;
import dataStructures.LinearNode;

public class PivotSortList {
	public static void bucketSort(LinearNode<ComparableInt> firstNode, ComparableInt pivotItem) {
		LinearNode<ComparableInt> currentNode = firstNode;
		
		LinearNode<ComparableInt> startingNode = null;
		LinearNode<ComparableInt> lessThanNodePointer = null;

		LinearNode<ComparableInt> equalNodeStartNode = null;
		LinearNode<ComparableInt> equalNodeStartNodePointer = null;

		LinearNode<ComparableInt> greaterThanStartNode = null;
		LinearNode<ComparableInt> greaterThanNodePointer = null;
		
		while (currentNode != null) {
			if (pivotItem.compareTo(currentNode.getElement().value) == 0) {
				addToNodesAndUpdatePointers(equalNodeStartNode, equalNodeStartNodePointer, currentNode);
			}

			if (pivotItem.compareTo(currentNode.getElement().value) < 0) {
				addToNodesAndUpdatePointers(startingNode, lessThanNodePointer, currentNode);
			}

			if (pivotItem.compareTo(currentNode.getElement().value) > 0) {
				addToNodesAndUpdatePointers(greaterThanStartNode, greaterThanNodePointer, currentNode);
			}

			currentNode = currentNode.getNext();
		}
		
		lessThanNodePointer.setNext(equalNodeStartNode);
		equalNodeStartNodePointer.setNext(greaterThanStartNode);

		firstNode = startingNode;

	}

	public static void addToNodesAndUpdatePointers(LinearNode<ComparableInt> pointerToFirst, LinearNode<ComparableInt> pointerToLast, LinearNode<ComparableInt> nodeToInsert) {
		if (pointerToFirst == null) {
			pointerToFirst = nodeToInsert;
			pointerToLast = nodeToInsert;
		} else {
			pointerToLast.setNext(nodeToInsert);
			pointerToLast = pointerToLast.getNext();
		}
	}
	
	public static void main(String[] args) {

		LinearNode<ComparableInt> firstnode = new LinearNode<ComparableInt>(new ComparableInt(1));
		LinearNode<ComparableInt> currentNode = firstnode;

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(2)));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(3)));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(4)));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(5)));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(6)));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<ComparableInt>(new ComparableInt(7)));
		currentNode = currentNode.getNext();

		bucketSort(firstnode, new ComparableInt(3));

		currentNode = firstnode;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}
}

package linkedLists;

import dataStructures.LinearNode;

public class SumLinearNodes {
	public static LinearNode<Integer> SumInverseList(LinearNode<Integer> firstNumber, LinearNode<Integer> secondNumber) {
		LinearNode<Integer> firstCurrentNode = firstNumber;
		LinearNode<Integer> secondCurrentNode = secondNumber;
		
		LinearNode<Integer> outputNodeStart = null;
		LinearNode<Integer> outputNodeLast = null;

		Integer carryForwardInt = 0;
		Integer nextCarryForwardInt = 0;
		
		while (firstCurrentNode != null || secondCurrentNode != null) {
			Integer firstInt = getNumberFromNode(firstCurrentNode);
			Integer secondInt = getNumberFromNode(secondCurrentNode);


			Integer summedInt = firstInt + secondInt;
			if (summedInt > 9) {
				summedInt = summedInt - 10;
				nextCarryForwardInt = 1;
			} else {
				nextCarryForwardInt = 0;
			}
			
			if (outputNodeStart == null) {
				outputNodeStart = new LinearNode<Integer>(summedInt);
				outputNodeLast = outputNodeStart;
			} else {
				LinearNode<Integer> node = new LinearNode<Integer>(summedInt + carryForwardInt);
				outputNodeLast.setNext(node);
				outputNodeLast = outputNodeLast.getNext();
			}
			
			firstCurrentNode = getNextNode(firstCurrentNode);
			secondCurrentNode = getNextNode(secondCurrentNode);
			
			carryForwardInt = nextCarryForwardInt;
		}

		if (carryForwardInt == 1) {
			LinearNode<Integer> node = new LinearNode<Integer>(carryForwardInt);
			outputNodeLast.setNext(node);
		}

		return outputNodeStart;
	}

	public static Integer getNumberFromNode(LinearNode<Integer> node) {
		Integer integer = 0;
		if (node != null) {
			integer = node.getElement();
		}
		return integer;
	}
	
	public static LinearNode<Integer> getNextNode(LinearNode<Integer> node) {
		if (node == null) return null;
		return node.getNext();
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
		
		
		LinearNode<Integer> secondNode = new LinearNode<Integer>(1);
		currentNode = secondNode;

		currentNode.setNext(new LinearNode<Integer>(2));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(3));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Integer>(7));
		currentNode = currentNode.getNext();


		LinearNode<Integer> sum = SumInverseList(firstnode, secondNode);

		currentNode = sum;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}
}

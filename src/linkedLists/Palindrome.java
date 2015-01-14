package linkedLists;

import dataStructures.LinearNode;

public class Palindrome {
	public static <T> String getStringFromLinearNode(LinearNode<T> firstNode) {
		StringBuilder sb = new StringBuilder();
		LinearNode<T> currentNode = firstNode;

		while (currentNode != null) {
			sb.append(currentNode.toString());
			
			currentNode = currentNode.getNext();
		}

		return sb.toString();
	}

	public static <T> boolean isPalindrome(LinearNode<T> firstNode) {
		String palindrome = getStringFromLinearNode(firstNode);
		StringBuilder sb = new StringBuilder(palindrome);

		String result1 = palindrome;
		String result2 = sb.reverse().toString();
		if (result1.equals(result2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {

		LinearNode<Character> firstnode = new LinearNode<Character>('r');
		LinearNode<Character> currentNode = firstnode;

		currentNode.setNext(new LinearNode<Character>('a'));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Character>('c'));
		currentNode = currentNode.getNext();
		
		currentNode.setNext(new LinearNode<Character>('e'));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Character>('c'));
		currentNode = currentNode.getNext();

		currentNode.setNext(new LinearNode<Character>('a'));
		currentNode = currentNode.getNext();
		
		currentNode.setNext(new LinearNode<Character>('r'));
		currentNode = currentNode.getNext();

		boolean output = isPalindrome(firstnode);

		System.out.println(output);
	}
}

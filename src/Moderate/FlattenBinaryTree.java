package Moderate;

import java.util.Stack;

public class FlattenBinaryTree {
	public static void main(String[] args) {
		BiNode root = new BiNode();
		root.data = 1;
		root.node1 = new BiNode();
		root.node2 = new BiNode();

		flattenBinaryTree(root);

		//printFlatTree(root);
	}

	public static void printFlatTree(BiNode v) {
		
	}

	public static void flattenBinaryTree(BiNode root) {
		Stack<BiNode> stack = new Stack<BiNode>();
		BiNode currentNode = root;
		BiNode nextNode = null;

		while (currentNode != null) {
			nextNode = getNextNode(currentNode, stack);
			currentNode.node2 = nextNode;
			nextNode.node1 = currentNode;

			currentNode = currentNode.node2;
		}

		currentNode = root;
		BiNode previousNode = null;

		while (currentNode != null) {
			previousNode = getPrevNode(currentNode, stack);
			currentNode.node1 = previousNode;
			previousNode.node2 = currentNode;

			currentNode = currentNode.node1;
		}
		
	}


	public static BiNode getNextNode(BiNode node, Stack<BiNode> nodeStack) {
		BiNode currentNode = null;
		currentNode = node.node2;
		
		if (currentNode == null) {
			BiNode parent = nodeStack.pop();
			BiNode nextNode = node;
			while (parent.node1 != nextNode) {
				nextNode = parent;
				parent = nodeStack.pop();
				if (nodeStack.empty()) return null;
			}

			currentNode = parent;
		} else {
			while (currentNode.node1 != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.node1;
			}
		}

		return currentNode;
	}



	public static BiNode getPrevNode(BiNode node, Stack<BiNode> nodeStack) {
		BiNode currentNode = null;
		currentNode = node.node1;
		
		if (currentNode == null) {
			BiNode parent = nodeStack.pop();
			BiNode nextNode = node;
			while (parent.node2 != nextNode) {
				nextNode = parent;
				parent = nodeStack.pop();
				if (nodeStack.empty()) return null;
			}

			currentNode = parent;
		} else {
			while (currentNode.node2 != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.node2;
			}
		}

		return currentNode;
	}

}

class BiNode {
	public BiNode node1, node2;
	public int data;
}

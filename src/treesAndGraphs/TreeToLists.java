package treesAndGraphs;

import java.util.ArrayList;
import java.util.Stack;

public class TreeToLists {

	public static void main(String[] args) {
		ArrayList<Node[]> lists = convertTreeToLists(new Node());
		
	}
	
	public static ArrayList<Node[]> convertTreeToLists(Node rootNode) {
		Stack<Node> orderStack = new Stack<Node>();
		recursiveList(rootNode, orderStack);
		return createListsFromStack(orderStack);
	}

	public static void recursiveList(Node node, Stack<Node> orderStack) {

		if (node.left != null) {
			recursiveList(node.left, orderStack);
		}

		if (node.right != null) {
			recursiveList(node.right, orderStack);
		}

		orderStack.push(node);

	}

	public static ArrayList<Node[]> createListsFromStack(Stack<Node> stack) {
		int base = 0;
		ArrayList<Node[]> nodes = new ArrayList<Node[]>();
		while (stack.peek() != null) {
			int nodesInList = (int) Math.pow(base, 2);

			Node[] nodeList = new Node[nodesInList];
			for (int i = 0; i < nodesInList; i++) {
				if (stack.peek() != null)
					break;
				Node currentNode = stack.pop();
				nodeList[i] = currentNode;
			}
			nodes.add(nodeList);
			base++;
		}
		return nodes;
	}
}

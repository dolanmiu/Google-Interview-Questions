package treesAndGraphs;

public class NextNodeInTree {
	public static Node getNextNode(Node startNode) {
		Node nextNode = null;
		if (startNode.right != null) {
			nextNode = goRightFarLeft(startNode);
		} else {
			if (startNode == startNode.parent.left) {
				nextNode = goUp(startNode);
			}

			if (startNode == startNode.parent.right) {
				nextNode = goUpUntilFirstLeft(startNode);
			}
		}

		return nextNode;
	}

	public static Node goRightFarLeft(Node startNode) {
		Node currentNode = startNode;
		currentNode = startNode.right;

		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;	
	}

	public static Node goUp(Node startNode) {
		return startNode.parent;
	}

	public static Node goUpUntilFirstLeft(Node startNode) {
		Node currentNode = startNode;
		while (currentNode != currentNode.parent.left) {
			currentNode = goUp(currentNode);
		}

		currentNode = goUp(currentNode);

		return currentNode;
	}
}

package treesAndGraphs;

public class CommonAncestor {

	public static Node commonAncesstor(Node node1, Node node2, Node root) {
		int node1Level = 0;
		int node2Level = 0;
		node1Level = findNodeLevel(node1, root, node1Level);
		node2Level = findNodeLevel(node2, root, node2Level);

		while (node1Level == node2Level) {
			if (node1Level > node2Level) {
				node1 = node1.parent;
				node1Level--;
			}
			if (node2Level > node1Level) {
				node2 = node2.parent;
				node2Level--;
			}
		}

		return converge(node1, node2);
	}

	public static int findNodeLevel(Node desiredNode, Node root,
			int currentLevel) {

		if (desiredNode == root) {
			return currentLevel;
		}

		if (root == null) {
			return -1;
		}

		int leftLevel = findNodeLevel(desiredNode, root.left, currentLevel + 1);
		int rightLevel = findNodeLevel(desiredNode, root.right,
				currentLevel + 1);

		if (leftLevel >= 0)
			return leftLevel;
		if (rightLevel >= 0)
			return rightLevel;

		return -1;
	}

	public static Node converge(Node node1, Node node2) {
		if (node1 == node2) {
			return node1;
		}

		Node result = converge(node1.parent, node2.parent);

		return result;
	}
}

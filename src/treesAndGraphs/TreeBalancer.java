package treesAndGraphs;

public class TreeBalancer {
	public static boolean isTreeBalanced(Node root) {
		Integer result = recursiveBalance(root);
		if (result < -1) {
			return false;
		} else {
			return true;
		}
	}

	public static Integer recursiveBalance(Node node) {
		
		if (node == null) {
			return -1;
		}

		Integer leftHeight = recursiveBalance(node.left);
		Integer rightHeight = recursiveBalance(node.right);

		if (leftHeight == -2 || rightHeight == -2) {
			return -2;
		}

		if (leftHeight == rightHeight) {
			return leftHeight + 1;
		} else if (leftHeight == rightHeight - 1) {
			return leftHeight + 1;
		} else if (leftHeight - 1 == rightHeight) {
			return rightHeight + 1;
		} else {
			return -2;
		}
	}
}

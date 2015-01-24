package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NodeSum {

	public static void findNodeSum(Node root) {
	ArrayList<Node> leafs = recursiveFindLeafs(root);
	int sum = 15;
	Queue<Node> result;
	for (Node leaf : leafs) {
		result = recursiveSum(leaf, new LinkedList(), sum, 0);
		if (result != null) {
			return result;
		}
	}

}

	public static Queue<Node> recursiveSum(Node node, Queue queue,
			int desiredSum, int sum) {
		queue.add(node);
		sum = sum + node.value;

		if (sum > desiredSum) {
			queue.poll();
			sum = recalculateQueue(queue);
		}

		if (sum == desiredSum) {
			return queue;
		}

		if (node.parent == null) {
			return null;
		}

		Queue<Node> result = recursiveSum(node.parent, queue, sum);

		return queue;

	}

	public static ArrayList<Node> recursiveFindLeafs(Node currentNode) {
		if (currentNode == null) {
			return new ArrayList<Node>();
		}

		if (currentNode.left == null && currentNode.right == null) {
			ArrayList<Node> leafs = new ArrayList<Node>(currentNode);
			return leafs;
		}

		ArrayList<Node> leftLeafs = recursiveFindLeafs(currentNode.left);
		ArrayList<Node> rightLeafs = recursiveFindLeafs(currentNode.right);

		return leftLeafs.addAll(rightLeafs);
	}
}

package treesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;


public class GraphTraverser {

	private Node[] nodes;

	private ArrayList<Node> path;
	private PriorityQueue<Node> workingNodes;
	private Map<Node, Integer> distances;
	private Map<Node, Node> predecessors;
	
	public GraphTraverser(Graph graph, Node startNode) {
		path = new ArrayList<Node>();
		nodes = graph.getNodes();
		workingNodes = new PriorityQueue();
		workingNodes.push(startNode);
		predecessors.put(startNode, null);
		
	}

	private ArrayList<Node> execute(Node endNode) {
		while (!workingNodes.empty()) {
			processNode();
		}
		
		Node step = endNode;

		while (predecessors.get(step) != null) {
			path.add(step);
			step = predecessors.get(step);
		}

		path.add(step);

		return Collections.reverse(path);
	}

	private void processNode() {
		Node node = workingNodes.dequeue();
		
		Node[] neighbours = node.getNeighbours();

		for (Node target : neighbours) {
			setDistance(target, node);
		}
	}

	private void setDistance(Node target, Node currentNode) {
		int newDistance = distances.get(currentNode) + currentNode.getDistance(target);
		if (newDistance < distances.get(target)) {
			distances.put(target, newDistance);
			predecessors.set(target, currentNode);
			workingNodes.enqueue(target);
		}
	}
}
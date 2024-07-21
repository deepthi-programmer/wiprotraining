package day13;
import java.util.*;
public class Graph {
	private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }
    public void addNode(int node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    public boolean addEdge(int from, int to) {
        addNode(from);
        addNode(to);

        // Temporarily add the edge
        adjacencyList.get(from).add(to);

        // Check for cycle
        if (hasCycle()) {
            // Remove the edge if it creates a cycle
            adjacencyList.get(from).remove(Integer.valueOf(to));
            return false;
        }
        return true;
    }
    private boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (Integer node : adjacencyList.keySet()) {
            if (dfs(node, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        for (Integer neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
            if (dfs(neighbor, visited, recStack)) {
                return true;
            }
        }
        recStack.remove(node);
        return false;
    }

	public static void main(String[] args) {
		Graph graph = new Graph();

        // Adding edges to the graph
        System.out.println(graph.addEdge(1, 2)); // Output: true
        System.out.println(graph.addEdge(2, 3)); // Output: true
        System.out.println(graph.addEdge(3, 4)); // Output: true
        System.out.println(graph.addEdge(4, 1)); // Output: false (creates a cycle)

        // Attempting to add an edge that creates a cycle
        System.out.println(graph.addEdge(2, 1)); // Output: false (creates a cycle)
    }

		// TODO Auto-generated method stub

	}



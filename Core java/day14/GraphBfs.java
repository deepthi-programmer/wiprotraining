package day14;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {
    private int numberOfVertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public GraphBfs(int vertices) {
        this.numberOfVertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);  // Since the graph is undirected
    }

    // Method to perform BFS starting from a given source node
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int vertex : adjacencyList[currentVertex]) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }

    // Main method to test the BFS implementation
    public static void main(String[] args) {
        GraphBfs graph = new GraphBfs(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("BFS starting from vertex 0:");
        graph.BFS(0);
    }
}
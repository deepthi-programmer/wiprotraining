package day14;
import java.util.LinkedList;

public class GraphDfs {
    private int numberOfVertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public GraphDfs(int vertices) {
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

    // Method to perform DFS starting from a given source node
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        DFSUtil(startVertex, visited);
    }

    // Utility method for DFS
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjVertex : adjacencyList[vertex]) {
            if (!visited[adjVertex]) {
                DFSUtil(adjVertex, visited);
            }
        }
    }

    // Main method to test the DFS implementation
    public static void main(String[] args) {
        GraphDfs graph = new GraphDfs(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("DFS starting from vertex 0:");
        graph.DFS(0);
    }
}

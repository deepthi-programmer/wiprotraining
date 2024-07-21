package day16;
import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
class Subset {
    int parent, rank;
}
public class KruskalAlgorithm {
	int vertices, edges;
    Edge[] edgeArray;

    KruskalAlgorithm(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeArray = new Edge[edges];
        for (int i = 0; i < edges; ++i) {
            edgeArray[i] = new Edge(0, 0, 0);
        }
    }
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void kruskalMST() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i = 0;

        for (i = 0; i < vertices; ++i) {
            result[i] = new Edge(0, 0, 0);
        }
        Arrays.sort(edgeArray);

        Subset[] subsets = new Subset[vertices];
        for (i = 0; i < vertices; ++i) {
            subsets[i] = new Subset();
        }

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < vertices - 1) {
            Edge next_edge = edgeArray[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
        System.out.println("Following are the edges in the constructed MST:");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }
	public static void main(String[] args) {
		 int vertices = 4;
	        int edges = 5;
	        KruskalAlgorithm graph = new KruskalAlgorithm(vertices, edges);

	        graph.edgeArray[0] = new Edge(0, 1, 10);
	        graph.edgeArray[1] = new Edge(0, 2, 6);
	        graph.edgeArray[2] = new Edge(0, 3, 5);
	        graph.edgeArray[3] = new Edge(1, 3, 15);
	        graph.edgeArray[4] = new Edge(2, 3, 4);

	        graph.kruskalMST();
		// TODO Auto-generated method stub

	}

}

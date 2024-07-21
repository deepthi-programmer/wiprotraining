package day15;
import java.util.*;
public class UnionFind {
	private int[] parent;
    private int[] rank;

    public UnionFind(int vertices) {
		// TODO Auto-generated constructor stub
	}
	public void UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }
    public boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return false; // Cycle detected
        }
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return true;
    }

	public static void main(String[] args) {
		int vertices = 5;

        // Edges in the graph (each pair represents an undirected edge)
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 1} // This edge will create a cycle
        };
        UnionFind uf = new UnionFind(vertices);

         boolean hasCycle = false;
         for (int[] edge : edges) {
       if (!uf.union(edge[0], edge[1])) {
         hasCycle = true;
         break;
        }
         }
         if (hasCycle) {
             System.out.println("Graph contains a cycle");
         } else {
             System.out.println("Graph does not contain a cycle");
         }
		// TODO Auto-generated method stub

	}

}

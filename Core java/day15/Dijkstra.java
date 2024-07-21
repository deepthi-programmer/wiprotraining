package day15;
import java.util.*;


	public class Dijkstra {
		static class Edge {
	        int target, weight;
	        public Edge(int target, int weight) {
	            this.target = target;
	            this.weight = weight;
	        }
	    }
		static class Node implements Comparable<Node> {
	        int vertex, distance;
	        public Node(int vertex, int distance) {
	            this.vertex = vertex;
	            this.distance = distance;
	        }
	        @Override
	        public int compareTo(Node other) {
	            return Integer.compare(this.distance, other.distance);
	        }
	    }
		 public static int[] dijkstra(List<List<Edge>> graph, int start) {
		        int n = graph.size();
		        int[] distances = new int[n];
		        Arrays.fill(distances, Integer.MAX_VALUE);
		        distances[start] = 0;
		        PriorityQueue<Node> pq = new PriorityQueue<>();
		        pq.add(new Node(start, 0));

		        while (!pq.isEmpty()) {
		            Node node = pq.poll();
		            int u = node.vertex;
		            int dist = node.distance;

		            if (dist > distances[u]) {
		                continue;
		            }
		            for (Edge edge : graph.get(u)) {
		                int v = edge.target;
		                int weight = edge.weight;
		                int newDist = distances[u] + weight;

		                if (newDist < distances[v]) {
		                    distances[v] = newDist;
		                    pq.add(new Node(v, newDist));
		                }
		            }
		        }

		        return distances;
		    }
		public static void main(String[] args) {
			int numVertices = 5;
	        List<List<Edge>> graph = new ArrayList<>();
	        for (int i = 0; i < numVertices; i++) {
	            graph.add(new ArrayList<>());
	        }
	        // Add edges: graph.get(from).add(new Edge(to, weight));
	        graph.get(0).add(new Edge(1, 10));
	        graph.get(0).add(new Edge(4, 3));
	        graph.get(1).add(new Edge(2, 2));
	        graph.get(1).add(new Edge(4, 4));
	        graph.get(2).add(new Edge(3, 9));
	        graph.get(3).add(new Edge(2, 7));
	        graph.get(4).add(new Edge(1, 1));
	        graph.get(4).add(new Edge(2, 8));
	        graph.get(4).add(new Edge(3, 2));
	        int startNode = 0;
	        int[] distances = dijkstra(graph, startNode);

	        System.out.println("Shortest distances from node " + startNode + ":");
	        for (int i = 0; i < distances.length; i++) {
	            System.out.println("To node " + i + " : " + distances[i]);
	        }
			// TODO Auto-generated method stub

		}

	}

	



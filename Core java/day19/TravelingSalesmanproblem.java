package day19;
import java.util.Arrays;
public class TravelingSalesmanproblem {
	  public static int FindMinCost(int[][] graph) {
	        int n = graph.length;
	        int[][] dp = new int[n][(1 << n)]; 

	       
	        for (int[] row : dp) {
	            Arrays.fill(row, -1);
	        }
	        return tsp(0, 1, dp, graph);
	    }

	    
	    private static int tsp(int city, int mask, int[][] dp, int[][] graph) {
	        int n = graph.length;

	        
	        if (mask == (1 << n) - 1) {
	            return graph[city][0];
	        }
	        if (dp[city][mask] != -1) {
	            return dp[city][mask];
	        }

	        int minCost = Integer.MAX_VALUE;
	        for (int nextCity = 0; nextCity < n; nextCity++) {
	            
	            if ((mask & (1 << nextCity)) == 0) {
	                int newCost = graph[city][nextCity] + tsp(nextCity, mask | (1 << nextCity), dp, graph);
	                minCost = Math.min(minCost, newCost);
	            }
	        }
	        dp[city][mask] = minCost;
	        return minCost;
	    }

	public static void main(String[] args) {
		int[][] graph = {
	            {0, 10, 15, 20},
	            {10, 0, 35, 25},
	            {15, 35, 0, 30},
	            {20, 25, 30, 0}
	        };

	        int minCost = FindMinCost(graph);
	        System.out.println("The minimum cost to visit all cities and return to the starting city is: " + minCost);
		// TODO Auto-generated method stub

	}

}

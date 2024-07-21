package day20;

public class KnapSackProblem {
	 public static int Knapsack(int W, int[] weights, int[] values) {
	        int n = weights.length;
	        int[][] dp = new int[n + 1][W + 1];

	        // Build table dp[][] in bottom up manner
	        for (int i = 0; i <= n; i++) {
	            for (int w = 0; w <= W; w++) {
	                if (i == 0 || w == 0) {
	                    dp[i][w] = 0;
	                } else if (weights[i - 1] <= w) {
	                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
	                } else {
	                    dp[i][w] = dp[i - 1][w];
	                }
	            }
	        }
	        return dp[n][W];
	    }
	public static void main(String[] args) {
		int W = 50; // Maximum capacity of the knapsack
        int[] weights = {10, 20, 30}; // Weights of the items
        int[] values = {60, 100, 120}; // Values of the items

        int maxValue = Knapsack(W, weights, values);
        System.out.println("Maximum value in Knapsack = " + maxValue);
		// TODO Auto-generated method stub

	}

}

package day20;

public class LongestCommmonSubsequence {
	public static int LCS(String text1, String text2) {
		 int m = text1.length();
		 int n = text2.length();
		
		
		 int[][] dp = new int[m+1][n+1];
		 for (int i = 0; i <= m; i++) {
	            for (int j = 0; j <= n; j++) {
	                if (i == 0 || j == 0)
	                    dp[i][j] = 0;
	                else if (text1.charAt(i-1) == text2.charAt(j-1))
	                    dp[i][j] = dp[i-1][j-1] + 1;
	                else
	                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	       
	        // Length of LCS is stored in dp[m][n]
	        return dp[m][n];
	    }
	public static void main(String[] args) {
		String text1 = "ABCBDAB";
		 String text2 = "BDCAB";
		 int length = LCS(text1, text2);
		 System.out.println("Length of Longest Common Subsequence: " + length);
		// TODO Auto-generated method stub

	}

}

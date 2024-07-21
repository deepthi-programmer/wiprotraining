package day17;

public class BoyerMoore {
	 private static int[] badCharacterHeuristic(String pat) {
	        int[] badChar = new int[256]; // Assume ASCII character set
	        for (int i = 0; i < 256; i++) {
	            badChar[i] = -1;
	        }

	        // Fill the actual value of the last occurrence of a character
	        for (int i = 0; i < pat.length(); i++) {
	            badChar[pat.charAt(i)] = i;
	        }
	        return badChar;
	 }
	       
	         public static int lastOccurrence(String txt, String pat) {
	         int m = pat.length();
	         int n = txt.length();
	        int[] badChar = badCharacterHeuristic(pat);
	         int s = 0; // s is the shift of the pattern with respect to the text
	        int lastIndex = -1; // Initialize the result

	        while (s <= (n - m)) {
	            int j = m - 1;
	            while (j >= 0 && pat.charAt(j) == txt.charAt(s + j)) {
	                j--;
	            }
	            if (j < 0) {
	                lastIndex = s;
	                s += (s + m < n) ? m - badChar[txt.charAt(s + m)] : 1;
	            } else {
	                // Shift the pattern so that the bad character in text aligns with the last occurrence in the pattern
	                s += Math.max(1, j - badChar[txt.charAt(s + j)]);
	            }
	        }

	        return lastIndex;
	    }
	         
	        
	public static void main(String[] args) {
		 String txt = "ABAAABCD";
	        String pat = "ABC";
	        int result = lastOccurrence(txt, pat);
	        if (result != -1) {
	            System.out.println("Last occurrence of the pattern found at index " + result);
	        } else {
	            System.out.println("Pattern not found in the text");
	        }
		// TODO Auto-generated method stub

	}

}

package day17;

public class RabinKrap {
	 public static final int d = 256; // Number of characters in the input alphabet
	    public static final int q = 101;
	    public static void search(String pat, String txt) {
	    	 int M = pat.length();
	    	 int N = txt.length();
	    	 int i, j;
	        int p = 0; // Hash value for pattern
	    	 int t = 0; // Hash value for text
	    	 int h = 1;

	    	
	    	for (i = 0; i < M - 1; i++)
	    	 h = (h * d) % q;
	    	for (i = 0; i < M; i++) {
	            p = (d * p + pat.charAt(i)) % q;
	            t = (d * t + txt.charAt(i)) % q;
	        }
	    	for (i = 0; i <= N - M; i++) {

	    		
	           if (p == t) {
	    		 /* Check for characters one by one */
	    		 for (j = 0; j < M; j++) {
	    		if (txt.charAt(i + j) != pat.charAt(j))
	    		 break;
	    		}
	    		 if (j == M)
	                    System.out.println("Pattern found at index " + i);
	            }

	            // Calculate hash value for next window of text: Remove leading digit,
	            // add trailing digit
	            if (i < N - M) {
	                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
	                if (t < 0)
	                    t = (t + q);
	            }
	        }
	    }

	public static void main(String[] args) {
		String txt = "ABCCDDAEFG";
		 String pat = "CDD";
		search(pat, txt);
		// TODO Auto-generated method stub

	}

}

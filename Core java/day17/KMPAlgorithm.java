package day17;

public class KMPAlgorithm {
	private void computeLPSArray(String pat, int M, int[] lps) {
        int length = 0; 
        int i = 1;
        lps[0] = 0;  
        while (i < M) {
        	 if (pat.charAt(i) == pat.charAt(length)) {
        	 length++;
        	lps[i] = length;
        	i++;
        	 } else {
        		 if (length != 0) {
        	        	length = lps[length - 1];
        	        	} else {
        	        	lps[i] = 0;
        	        	i++;
        	        	}
        	 }
        }
	}
	public void KMPSearch(String pat, String txt) {
		 int M = pat.length();
		 int N = txt.length();
		 int[] lps = new int[M];

	        
	        computeLPSArray(pat, M, lps);

	        int i = 0; 
	        int j = 0;  
	        while (i < N) {
	            if (pat.charAt(j) == txt.charAt(i)) {
	                j++;
	                i++;
	            }
	            if(j==M){
	            	System.out.println("Found pattern at index " + (i - j));
	            	                j = lps[j - 1];
	            	            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
	            	                if (j != 0) {
	            	                    j = lps[j - 1];
	            	                } else {
	            	                    i++;
	            	                }
	            	            }
	            	        }
	            	    }


	public static void main(String[] args) {
		KMPAlgorithm kmp = new KMPAlgorithm();
		 String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		 kmp.KMPSearch(pat, txt);
		// TODO Auto-generated method stub

	}

}

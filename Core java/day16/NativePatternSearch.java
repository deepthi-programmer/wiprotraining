package day16;

public class NativePatternSearch {
	public static void naivePatternSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisonCount = 0;
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
           
            // For current index i, check for pattern match
            for (j = 0; j < patternLength; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }
       
        // Print the total number of comparisons made
        System.out.println("Total number of comparisons: " + comparisonCount);
    }
	
	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		 String pattern = "ABABCABAB";
		
		 System.out.println("Text: " + text);
		 System.out.println("Pattern: " + pattern);
		 System.out.println("Searching for pattern in the text...");
		
		naivePatternSearch(text, pattern);
		// TODO Auto-generated method stub

	}

}

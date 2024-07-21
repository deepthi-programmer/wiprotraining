package day16;

public class StirngOperations {
	public static String concatenateReverseExtract(String str1, String str2, int length) {
        // Concatenate the two strings
        String concatenated = str1 + str2;

        // Handle the case where both strings are empty
        if (concatenated.isEmpty()) {
            return "";
        }
        String reversed = new StringBuilder(concatenated).reverse().toString();

        // If the requested substring length is greater than the reversed string length, return the whole string
        if (length >= reversed.length()) {
            return reversed;
        }
        int startIndex = (reversed.length() - length) / 2;

        // Extract and return the middle substring
        return reversed.substring(startIndex, startIndex + length);
    }

	public static void main(String[] args) {
		String str1 = "Hello";
        String str2 = "World";
        int length = 5;
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("Requested length of middle substring: " + length);
        System.out.println("Result: " + concatenateReverseExtract(str1, str2, length));
        System.out.println("Result (empty strings): " + concatenateReverseExtract("", "", 3));
        System.out.println("Result (substring length larger than string): " + concatenateReverseExtract("A", "B", 10));
        System.out.println("Result (one empty string): " + concatenateReverseExtract("Hello", "", 3));
        System.out.println("Result (one empty string): " + concatenateReverseExtract("", "World", 3));
		// TODO Auto-generated method stub

	}

}

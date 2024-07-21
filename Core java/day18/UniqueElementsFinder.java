package day18;

public class UniqueElementsFinder {

	public static void main(String[] args) {
		  int[] nums = {1, 2, 3, 2, 1, 4};
	        int[] result = findUniqueElements(nums);
	        System.out.println("The two non-repeating elements are: " + result[0] + " and " + result[1]);
	    }
	public static int[] findUniqueElements(int[] nums) {
        // Step 1: XOR all the elements in the array
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int setBit = xorResult & -xorResult; // This isolates the rightmost set bit
        int unique1 = 0, unique2 = 0;
        for (int num : nums) {
            if ((num & setBit) != 0) {
                unique1 ^= num;
            } else {
                unique2 ^= num;
            }
        }
        return new int[]{unique1, unique2};
		// TODO Auto-generated method stub

	}

}

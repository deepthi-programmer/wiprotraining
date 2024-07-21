package day23;
import java.util.Arrays;
public class GenericSwap {
	public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap (Integer array): " + Arrays.toString(intArray));
        swap(intArray, 1, 3); // Swap elements at index 1 and 3
        System.out.println("After swap (Integer array): " + Arrays.toString(intArray));
        String[] strArray = {"one", "two", "three", "four"};
        System.out.println("Before swap (String array): " + Arrays.toString(strArray));
        swap(strArray, 0, 2); // Swap elements at index 0 and 2
        System.out.println("After swap (String array): " + Arrays.toString(strArray));
		// TODO Auto-generated method stub
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Before swap (Double array): " + Arrays.toString(doubleArray));
        swap(doubleArray, 1, 2); // Swap elements at index 1 and 2
        System.out.println("After swap (Double array): " + Arrays.toString(doubleArray));
	}

}


public class ArrayMethodsTester {
	public static void main(String[] args) {
		int[] array = {1, 1, 7, 4, 2, 23, 15, 16};
		ArrayMethods methods = new ArrayMethods(array);
		
		System.out.println("Original array is: " + methods.printArray());

		// a. Swap first and last
		methods.swapFirstAndLast();
		System.out.println("Swapping first and last makes: " + methods.printArray());
		
		// b. Shift all to right
		methods.shiftRight();
		System.out.println("Shifting to right makes: " + methods.printArray());
		
		// c. Make even elements zero
		methods.zeroEvenElements();
		System.out.println("Zeroing even elements makes: " + methods.printArray());
		
		// d. Replace each with the larger of two neighbors
		methods.maximizeValues();
		System.out.println("Replacing values with the larger of two neighbors makes: "
				+ methods.printArray());
		
		// e. Remove middle element
		methods.removeMiddle();
		System.out.println("Removing the middle makes: " + methods.printArray());
		
		// f. Evens to front
		methods.evensToFront();
		System.out.println("Moving the evens to the front makes: " + methods.printArray());
		
		// g. Second largest element
		System.out.println("The second largest value is " + methods.secondLargest());
		
		// h. isIncreasing
		System.out.println("The array is increasing: " + methods.isIncreasing());
		
		// i. Adjacent duplicates
		System.out.println("Array has adjacent duplicate elements: " + methods.hasEqualAdjacents());
		
		// j. Has any duplicates
		System.out.println("Array has any duplicate elements: " + methods.hasDuplicates()); 
		
		
	}
}

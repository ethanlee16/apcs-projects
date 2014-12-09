import java.util.Random;
import java.util.ArrayList;
public class IntegerSorter {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[10];
		int min, max, underTwentyFive = 0;
		double avg = 0;
		
		for(int i = 0; i < 10; i++) {
			// 51 - 10 for readability:
			// range is from 10 - 50 (inclusive),
			// so max exclusive is 51 and min is 10;
			// 10 acts as the offset here
			arr[i] = rand.nextInt(51 - 10) + 10; 
		}
		
		for(int i = 10; i > 0; i--) {
			list.add(arr[i-1]);
		}
		
		max = list.get(0);
		min = list.get(0);
		
		for(int num : list) {
			avg += num;
			if(num < 25) {
				underTwentyFive++;
			}
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		avg /= 10;
		
		/* PRINT TIME */
		System.out.println("The following are the original array's contents:");
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("The following are the ArrayList's contents:");
		for(int i = 0; i < 10; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Average was: " + avg
				+ "\nMinimum was " + min
				+ "\nMaximum was " + max
				+ "\nThe number of numbers under 25 was " + underTwentyFive);
		
	}
}


public class ArrayMethods {
	
	private int[] values;
	
	public ArrayMethods(int[] initialValues) {
		values = initialValues;
	}
	
	public void swapFirstAndLast() {
		int firstVal = values[0];
		values[0] = values[values.length - 1];
		values[values.length - 1] = firstVal;
	}
	
	public void shiftRight() {
		int lastVal = values[values.length - 1];
		for(int i = values.length - 1; i > 0; i--) {
			values[i] = values[i - 1];
		}
		values[0] = lastVal;
	}
	
	public void shiftLeftBy(int positionOffset) {
		for(int i = positionOffset; i < values.length - 1; i++) {
			int origVal = values[i + 1];
			values[i + 1] = values[i];
			values[i] = origVal;
		}
	}
	
	public void shiftRightBy(int positionOffset) {
		for(int i = positionOffset; i < values.length; i++) {
			int origVal = values[i - 1];
			values[i - 1] = values[i];
			values[i] = origVal;
		}
	}
	
	public void zeroEvenElements() {
		for(int i = 0; i < values.length; i ++) {
			if(values[i] % 2 == 0) {
				values[i] = 0;
			}
		}
	}
	
	public void maximizeValues() {
		for(int i = 1; i < values.length - 1; i++) {
			values[i] = Math.max(values[i - 1], values[i + 1]);
		}
	}
	
	public void removeMiddle() {
		if(values.length % 2 != 0) {
			// Integer division
			int middle = values.length / 2;
			values[middle] = 0;
			this.shiftLeftBy(middle);
		}
		else {
			int middle = values.length / 2;
			values[middle] = 0;
			values[middle - 1] = 0;
			this.shiftLeftBy(middle);
			this.shiftLeftBy(middle - 1);
		}
	}
	
	public void evensToFront() {
		int evenCounter = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] % 2 == 0) {
				for(int j = i; j > evenCounter; j--) {
					int origVal = values[j - 1];
					values[j - 1] = values[j];
					values[j] = origVal;
				}
				evenCounter++;
			}
		}
	}
	
	public int secondLargest() {
		int largest = values[0];
		int ret = values[0];
		for(int num : values) {
			if(num > largest) {
				largest = num;
			}
		}
		for(int num : values) {
			if(num > ret && num < largest) {
				ret = num;
			}
		}
		return ret;
	}
	
	public boolean isIncreasing() {
		boolean ret = true;
		int prevNum = values[0];
		for(int num : values) {
			if(num < prevNum) {
				ret = false;
			}
			prevNum = num;
		}
		return ret;
	}
	
	public boolean hasEqualAdjacents() {
		for(int i = 1; i < values.length; i++) {
			if(values[i - 1] == values[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasDuplicates() {
		for(int i = 0; i < values.length; i++) {
			for(int j = i + 1; j < values.length; j++) {
				if(values[i] == values[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int sumWithoutSmallest() {
		int smallest = values[0];
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] < smallest) {
				smallest = values[i];
			}
			sum += values[i];
		}
		return sum - smallest;
	}
	
	public void reverseElements() {
		// Switch opposite elements - concurrently!
		for(int i = 0; i < values.length / 2; i++) {
			int origVal = values[values.length - 1 - i];
			values[values.length - 1 - i] = values[i];
			values[i] = origVal;
		}
	}
	
	public String printArray() {
		String out = "Array is (";
		for(int i = 0; i < values.length; i++) {
			out += values[i] + ", ";
		}
		out += ").";
		return out;
	}
}
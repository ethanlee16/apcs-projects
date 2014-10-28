/**
 * Counter.java - the coolest Counter in the world!
 * v. 1.0
 * 
 * It's a counter. It's perfect and doesn't need any revisions. Unless it was counting revisions.
 * Or, you know, had a major unnoticed bug that allowed remote code execution.
 * @author ethan.lee
 *
 */

public class Counter {
	
	private int value;
	
	public Counter() {
		value = 0;
	}
	
	public Counter(int start) {
		value = start;
	}
	
	public int getValue() {
		return value;
	}
	public void click(){
		value++;
	}
	public void undo(){
		value--;
		value = Math.max(value, 0);
	}
	
}


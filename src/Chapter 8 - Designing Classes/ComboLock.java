/**
 * ComboLock.java
 * @author ethan
 *
 */
public class ComboLock {
	
	private int[] combo = new int[3];
	private int currentOffset, turnCount;
	private boolean isUnlocked;
	
	public static void main(String[] arghhh) {
		// To test the ComboLock
		ComboLock lock = new ComboLock(16, 34, 25);
		int tries = 0;
		long startTime = System.nanoTime();
		/* 
		lock.turnRight(16);
		lock.turnLeft(22);
		lock.turnRight(31);
		if(lock.open()) {
			System.out.println("Click! The lock opened.");
		}
		else {
			System.out.println("You pull on the lock repeatedly, to no avail.");
		} 
		*/
		
		// Chase Sadri gave me this cool idea
		// to brute force the lock and see
		// how quickly the computer is able
		// to crack the combination! Run 
		// to see the results yourself!
		
		dance:
		for(int a = 0; a < 40; a++) {
			for(int b = 0; b < 40; b++) {
				for(int c = 0; c < 40; c++) {
					tries++;
					System.out.println("Tried " + a + "-" + b + "-" + c);
					if(lock.open(a, b, c)) {
						System.out.println("Cracked combination: " 
								+ a + ", " + b + ", " + c + " in " 
								+ tries + " tries @ " 
								+ ((System.nanoTime() - startTime) / 1000000.0 ) + "ms. COMPUDARZ!");
						break dance;
					}
				}
			}
		}
		
	}
	
	public ComboLock(int secret1, int secret2, int secret3) {
		if(secret1 > 39 || secret1 < 0 
				|| secret2 > 39 || secret2 < 0 
				|| secret3 > 39 || secret3 < 0) {
			throw new IllegalArgumentException();
		}
		combo[0] = secret1;
		combo[1] = secret2;
		combo[2] = secret3;
		this.reset();
	}
	
	public void reset() {
		currentOffset = 0;
		turnCount = 0;
		isUnlocked = false;
	}
	
	public void turnLeft(int ticks) {
		int attempt = currentOffset - ticks;
		while(attempt < 0) {
			attempt += 40;
		}
		// System.out.println(attempt + "\t" + currentOffset);
		if(attempt == combo[turnCount] && turnCount == 0) {
			isUnlocked = true;
		}
		else if(attempt != combo[turnCount]) {
			isUnlocked = false;
		}
		currentOffset = attempt;
		turnCount++;
	}
	
	public void turnRight(int ticks) {
		int attempt = currentOffset + ticks;
		while(attempt > 40) {
			attempt -= 40;
		}
		// System.out.println(attempt + "\t" + currentOffset);
		// ABOUT THIS CONDITIONAL:
		// If isUnlocked is already false,
		// it will remain false and there will
		// be no change. Only one number has
		// to be wrong for isUnlocked to be false.
		// This ensures that.
		
		if(attempt == combo[turnCount] && turnCount == 0) {
			isUnlocked = true;
		}
		else if(attempt != combo[turnCount]) {
			isUnlocked = false;
		}
		currentOffset = attempt;
		turnCount++;
	}
	
	public boolean open() {
		return isUnlocked && turnCount == 3;
	}
	
	public boolean open(int n1, int n2, int n3) {
		if(n1 == combo[0] && n2 == combo[1] && n3 == combo[2]) {
			return true;
		}
		else {
			return false;
		}
	}
}

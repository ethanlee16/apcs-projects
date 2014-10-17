/**
 * 
 * Architect.java - builds console houses of any size!
 * 
 * 0.1 only built the top and second layers of roof
 * 0.2 puts the whole roof on
 * 1.0 actually builds the whole house!
 * 
 * @author ethan.lee and Tiancheng "Timothy" Gu
 *
 * Modifications by Timothy Gu are mad available under the ISC license:
 *
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL
 * WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE
 * FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER
 * IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING
 * OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * 
 * END ISC LICENSE
 *
 */
import java.util.*;

public class Architect {

	private static Scanner prompt = new Scanner(System.in);
	private static StringBuilder houseStr = new StringBuilder();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Architect. Please enter a number for the width of your new house. "
				+ "The minimum is five, but the standard is seven.");
		
		//Loops until width is a valid response, Maths all the things after width is actually determined
		int width = prompt.nextInt();	
		while (width < 5){
			System.out.println("Error: number must be at "
				+ "least 5. Try again:  ");
			width = prompt.nextInt();
		}
		
		/* NOTE: These values are floored because of the nature of bitwise
		 * shifts.
		 * This generates more realistic roofs than ceiled ones, because we want
		 * to exclude the central star when calculating spaces.
		 * If (width & 1) == 1, width can always be described as
		 * width == (half << 1) + 1. The `+ 1` is for the central star.
		 * E.g. int width = 15; current rounding:
		 *        *
		 *     *     *
		 *   *         *
		 * +-------------+
		 *
		 * Ceiling rounding:
		 * int half    = -((-width)  >> 1);
		 * int fourth  = -((-half)   >> 1);
		 * int eighth  = -((-fourth) >> 1);
		 *
		 *         *
		 *     *     *
		 *   *         *
		 * +-------------+
		 *
		 * For evens, the extra compensation for the star results in the
		 * unavoidable shifting right of the star:
		 * width = 16
		 *         *
		 *     *      *
		 *   *          *
		 * +--------------+
		 */
		int half    = width  >> 1;
		int fourth  = half   >> 1;
		int eighth  = fourth >> 1;
		// Reduced accuracy values for the mid-star spaces.
		// Have to use the lower-accuracy values to compensate for the lower
		// accuracy of the position of stars
		int halfR   = fourth << 1;
		int fourthR = eighth << 1;
		String equals = "";
		
		//First star for top of roof is about halfway
		for(int count = half; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		//Seconds stars are about 1/4 of the way
		for (int count = fourth; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*");
		
		//Accounts for blanks in between two mid-stars
		for (int count = width - halfR - 2; count > 0; count--) {
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		for (int count = eighth; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*");
		
		for (int count = width - fourthR - 2; count > 0; count--) {
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		// Reusable code: the top two rows for the house are the same idea:
		// beginning symbol, character all the way across, and end symbol.

		for (int count = width - 2; count > 0; count--){
			equals += "-";
		}
		houseStr.append("+" + equals + "+\n");
		houseStr.append("|" + equals.replace("-", " ") + "|\n");
		
		//Reset equals string for new loop
		equals = "";
		
		// Reusable code: the bottom three rows are essentially the same:
		// they have a beginning symbol, a repeating character, three symbols for the door,
		// repeating character again, and end symbol
		//
		// For example: +---+-+---+ makes up the bottom of the house, and |   .-.   | makes
		// the top of the door frame.
		
		// For even numbers, the only way to make it look OK is put one more
		// space on one side. Hence equalsS(hort) string.
		
		String equalsS;
		for (int count = half - 2; count > 0; count--){
			equals += " ";
		}
		if ((width & 1) == 0)
			equalsS = equals.substring(0, equals.length() - 1);
		else
			equalsS = equals;

		// Flipping a coin: heads for putting extra space on the left
		//                  tails for putting extra space on the right
		// Head.
		houseStr.append("|" + equals + ".-." + equalsS + "|\n");
		houseStr.append("|" + equals + "| |" + equalsS + "|\n");
		houseStr.append("+" + equals.replace(" ", "-") + "+-+" + equalsS.replace(" ", "-") + "+");
		
		System.out.println(houseStr.toString());
		
	}

}

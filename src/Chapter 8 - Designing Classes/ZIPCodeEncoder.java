/**
 * ZIPCodeEncoder.java
 * @author ethan
 *
 * TODO: 
 * - separate ZIPCodeEncoder behavior from
 *   actual JPanel to reduce redundancy.
 * x needs to exit after last dialog 
 *   after providing bar code [solved]
 * x the logic involving encodedInput is
 *   literally a hack. efficiency could
 *   be greatly improved. [solved]
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

@SuppressWarnings("serial")
public class ZIPCodeEncoder extends JPanel implements ActionListener {
	
	private static String input;
	private String encodedInput = "";
	private int place = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		input = JOptionPane.showInputDialog(frame, "Enter a ZIP Code or a bar code "
				+ "(full bars as '|' and half bars as ':'. Be sure to put full bars "
				+ "between the entire code.)");
		
		// A SAMPLE THAT CAN BE USED FOR TESTING IS: ||:|:::|:|:||::::::||:|::|:::||| //
		// SHOULD VALIDATE TO 95014 WITH CHECK DIGIT VALIDATION //
		
		if(input.matches("\\d\\d\\d\\d\\d")) {
			ZIPCodeEncoder encoder = new ZIPCodeEncoder();
			encoder.setBounds(0, 0, 220, 105);
			frame.getContentPane().add(encoder);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(null);
			
			JButton copy = new JButton("Copy bar code to clipboard");
			copy.addActionListener(encoder);
			copy.setBounds(15, 70, 200, 25);
			frame.getContentPane().add(copy);
			
			frame.setSize(220, 125);
			frame.setVisible(true);
		}
		else {
			ZIPCodeEncoder encoder = new ZIPCodeEncoder();
			// To get rid of opening and closing bars
			input = input.substring(1, input.length() - 1);
			input = input.replace('|', '1');
			input = input.replace(':', '0');
	
			// Regex from http://stackoverflow.com/questions/
			// 22283856/splitting-string-into-n-length-elements-for-an-array
			String[] separatedNums = input.split("(?<=\\G\\d{5})");
			String zipNums = "";
			for(int i = 0; i < 6; i++) {
				zipNums += encoder.decodeNumber(separatedNums[i]);
			}
			int checkDigit = Integer.valueOf(zipNums.substring(zipNums.length() - 1, zipNums.length()));
			int sum = 0;
			int zip = Integer.valueOf(zipNums.substring(0, zipNums.length() - 1));
			while(zip != 0) {
				sum += zip % 10;
				zip /= 10;
			}
			if((sum + checkDigit) % 10 != 0) {
				JOptionPane.showMessageDialog(null, "The check digit was incorrect. Extracted ZIP was " 
						+ zipNums.substring(0, zipNums.length() - 1));
			}
			else {
				JOptionPane.showMessageDialog(null, "The check digit verified, and the ZIP was "
						+ zipNums.substring(0, zipNums.length() - 1));
			}
			System.exit(0); // solves close dialog, could also be break; return;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		// paintComponent is constantly called
		// setting encodedInput back to empty
		// corrects redundancy issue
		
		encodedInput = "";
		char[] zip = input.toCharArray();
		for(char c : zip) {
			char[] digit = encodeNumber(Character.getNumericValue(c)).toCharArray();
			for (char d : digit) {
				encodedInput += d;
				makeBar(g, d);
				place++;
			}
		}
		
		int sum = 0;
		for(char n : zip) {
			sum += Character.getNumericValue(n);
		}
		int max = (int) (Math.ceil(sum / 10.0) * 10);
		
		char[] checkDigit = encodeNumber(max - sum).toCharArray();
		for(char c : checkDigit) {
			encodedInput += c;
			makeBar(g, c);
			place++;
		}
		// These are the guiding bars for all codes (beginning and end)
		g.fillRect(46, 47, 2, 6);
		g.fillRect(170, 47, 2, 6);
		// This is the ZIP code as text
		g.drawString(input, 46, 40);
	}
	
	public void makeBar(Graphics g, char d) {
		switch(d) {
		case '0':
			g.fillRect(4 * place + 50, 50, 2, 3);
			break;
		case '1':
			g.fillRect(4 * place + 50, 47, 2, 6);
			break;
		}
	}
	
	public String encodeNumber(int num) {
		switch(num) {
		case 0:
			return "11000";
		case 1:
			return "00011";
		case 2:
			return "00101";
		case 3:
			return "00110";
		case 4:
			return "01001";
		case 5:
			return "01010";
		case 6:
			return "01100";
		case 7:
			return "10001";
		case 8:
			return "10010";
		case 9:
			return "10100";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public int decodeNumber(String s) {
		switch(s) {
		case "11000":
			return 0;
		case "00011":
			return 1;
		case "00101":
			return 2;
		case "00110":
			return 3;
		case "01001":
			return 4;
		case "01010":
			return 5;
		case "01100":
			return 6;
		case "10001":
			return 7;
		case "10010":
			return 8;
		case "10100":
			return 9;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(new StringSelection("|" + encodedInput
				.replace('1', '|').replace('0', ':') + "|"), null);
		JOptionPane.showMessageDialog(null, "Got it! The code was copied.");
	}
}
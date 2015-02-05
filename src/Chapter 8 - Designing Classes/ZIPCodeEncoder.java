/**
 * ZIPCodeEncoder.java
 * @author ethan
 *
 */
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ZIPCodeEncoder extends JPanel {
	
	private static String input;
	private int place = 0;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		input = JOptionPane.showInputDialog(frame, "Enter a ZIP Code or a bar code "
				+ "(full bars as '|' and half bars as ':')");
		if(input.matches("\\d\\d\\d\\d\\d")) {
			frame.getContentPane().add(new ZIPCodeEncoder());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(220, 105);
			frame.setVisible(true);
		}
		else {
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		char[] zip = input.toCharArray();
		
		for(char c : zip) {
			char[] digit = encodeNumber(Character.getNumericValue(c)).toCharArray();
			for (char d : digit) {
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
			makeBar(g, c);
			place++;
		}
		//JLabel label = new JLabel(input);
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
	
	
}

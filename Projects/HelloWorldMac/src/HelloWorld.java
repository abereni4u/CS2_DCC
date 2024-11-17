import java.util.ArrayList;

/**
 * 
 */

public class HelloWorld {

	/**
	 * @param This is a docstring
	 */
	public static void main(String[] args) {
		System.out.println(IsPalindrome("racecar"));
		Ball(10.0);
	}
	
	public static boolean IsPalindrome(String n) {
		String empty = "";
		for (int i = 0; i < n.length(); i++) {
			empty = String.valueOf(n.charAt(i)).toLowerCase().concat(empty);
		}
		if (empty.equals(n.toLowerCase())) {
			System.out.println("Empty: " + empty);
			return true;
		}
		else
			System.out.println("Empty: " + empty);
			return false;
	}
	
	public static void Ball(double h) {
		double coe = 0.85; 
		int bounce = 0;
		double total_distance = h;
		while (h > .05) {
			h = h * coe;
			total_distance +=(h*2);
			bounce += 1;
		}
		System.out.println("Total Distance:" + total_distance);
		System.out.println("Total Bounces:" + bounce);
		
	}
}

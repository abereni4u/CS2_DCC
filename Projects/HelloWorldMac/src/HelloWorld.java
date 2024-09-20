/**
 * 
 */


public class HelloWorld {

	/**
	 * @param This is a docstring
	 */
	public static void main(String[] args) {
		// This is a comment
		System.out.println("Testing out coding on mac\n");
		
		int myInt = 1;
		String myString = "This is MY string!";
		
		for(int i = 1; i<=10; i++) {
			if(i == 1) {
				System.out.printf("Line #%d: This is a formatted string \n", myInt);
			}
			else {
				System.out.printf("Line #%d: This is another formatted string \n", myInt);
			}
			myInt +=1;
		}
		
		System.out.print("\n");
		System.out.println(myString);
	}

}

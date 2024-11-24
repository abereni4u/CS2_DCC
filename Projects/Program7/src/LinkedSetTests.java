//package reference;

import java.util.Set;

/** 
 * DCC - CPS142 - Program 7 - LinkedSet test program
 * Author: Adam Divelbiss
 * 
 */
public class LinkedSetTests
{
	public static void main(String[] args) 
	{
		testStringSet();
		System.out.println("\n\nDone.");
	}  // end main

	
	/**
	 * Method used to test the set with String values
	 */
	private static void testStringSet()
	{
		int testCount = 0;
		
		System.out.println("Testing a LinkedSet of String objects.");
		System.out.println();
		System.out.println();
		
		Set<String> mySet = new LinkedSet<>();
		String[] testValues = {"5", "15", "25", "35", "45", "55", "65", "75"};
		int s=0,e=0;

		System.out.println("-------------------------");
		System.out.printf("Test %d: - isEmpty\n", testCount++);
		System.out.println("isEmpty should be true, isEmpty = " + mySet.isEmpty());
		System.out.print("\n\n");
		
		System.out.println("-------------------------");
		System.out.printf("Test %d: - add\n", testCount++);
		System.out.print("adding: ");
		s = 0; e = 4;
		for (int i=s; i<e; i++ ) {
			System.out.printf("%s ",testValues[i]);
			mySet.add(testValues[i]);
		}
		System.out.print("\n\n");

		System.out.println("Set should contain:");
		displayArray(testValues,s,e);
		System.out.print("\n\n");
		displaySet(mySet);
		System.out.print("\n\n");

		System.out.println("-------------------------");
		System.out.printf("Test %d: - isEmpty\n", testCount++);
		System.out.println("isEmpty should be false, isEmpty = " + mySet.isEmpty());
		System.out.print("\n\n");

		System.out.println("-------------------------");
		System.out.printf("Test %d: - add more to end\n", testCount++);
		System.out.print("adding: ");
		s = 4; e = testValues.length;
		for (int i=s; i<e; i++ ) {
			System.out.printf("%s ",testValues[i]);
			mySet.add(testValues[i]);
		}
		System.out.print("\n\n");

		System.out.println("Set should contain:");
		displayArray(testValues,0,e);
		System.out.print("\n\n");
		displaySet(mySet);
		System.out.print("\n\n");

		System.out.println("isEmpty should be false, isEmpty = " + mySet.isEmpty());
		System.out.println();
		
		System.out.println("-------------------------\n");
		System.out.printf("Test %d: - contains object\n", testCount++);
		System.out.println("contains 45, should return true:   " + mySet.contains("45"));
		System.out.println("contains 46, should return false:  " + mySet.contains("46"));
		System.out.println();
		
		
		System.out.println("-------------------------\n");
		System.out.printf("Test %d: - remove object\n", testCount++);
		System.out.println("remove 45, should return true:   " + mySet.remove("45"));
		System.out.println("remove 46, should return false:  " + mySet.remove("46"));
		System.out.println();
		String[] remValues = {"5", "15", "25", "35", "55", "65", "75"};
		System.out.println("Set should contain:");
		displayArray(remValues,0,remValues.length);
		System.out.print("\n\n");
		displaySet(mySet);
		System.out.print("\n\n");

		
		System.out.println("------------------------");
		System.out.printf("Test %d: - clear()\n", testCount++);
		mySet.clear();

		System.out.println("isEmpty should be true, isEmpty = " + mySet.isEmpty());
		System.out.println();
		

	} // end testStringList

	
	/**
	 * Display contents of the set to be tested using the toString method.
	 * @param <E>
	 * @param set
	 */
	private static <E> void displaySet(Set<E> set)
	{
		System.out.println("The set contains " + set.size() + " item(s), as follows:");
		System.out.println(set);
	} // end displayList
	
	/**
	 * Display the contents of the given array
	 * @param <E>
	 * @param array - the array to display
	 * @param s - start index, 0-referenced
	 * @param e - end index exclusive
	 */
	private static <E> void displayArray(E[] array, int s, int e) {
		System.out.print("[");
		for (int i=s; i<e; i++) {
			if (i>0) System.out.print(", ");
			System.out.print(array[i]);
		}
		System.out.print("]");
	}
	
}  // end Driver

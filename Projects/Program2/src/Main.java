import java.util.ArrayList;

//*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*
//                STOP AND READ                //
//*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*
//
// DO NOT START YOUR WORK IN THIS FILE
// THIS SHOULD BE THE ABSOLUTE LAST FILE YOU WORK ON.
// WRITE ALL OF THE OTHER CODE FIRST
// THEN COMPLETE THIS PART OF THE PROJECT.
//
//WORK ON THE FILES IN THIS ORDER
// 1. Boundable.java
// 2. BoundingBox.java
// 3. Shape.java
// 4. Rectangle.java
// 5. Circle.java
// 6. Triangle
// 7. RightTriangle
// 8. IsoTriangle
//
// WHEN YOU ARE FINSIHED WITH THE CLASSES LISTED ABOVE
// TEST YOUR CODE USING THIS PROGRAM.
//
//*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*
//                STOP AND READ                //
//*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*


/**
 * CPS142 - Fall 2024
 * Program 2
 * @author Adam Divelbiss
 * Simple test program for the Shape classes
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("CPS142 - Program 2 - Shape System Tests");
		System.out.println();

		// An ArrayList of Boundable objects to hold our shapes.
		ArrayList<Boundable> data = new ArrayList<>();
		
		// Step 1:  Rectangle 
		// TODO: Create a rectangle with width of 16 and height of 9 and add to the data
		
		// Step 2:  Circle
		// TODO: Create and add to data, a Circle with diameter 16.
		
		// Step 3:  RightTriangle
		// TODO: Create and add to data, a RightTriangle with width and height equal to 16.0
		
		// Step 4:  IsoTriangle
		// TODO: Create and add to data, a IsoTriangle with width 9 and height 16.

		// Step 5:  Write code to print the current state of each shape
		System.out.println("Shapes:");
		// TODO:  Use an "Enhanced For Loop" to print to the console information for each shape in the data ArrayList
		
		// Step 6:  Write code to find the shape with the smallest perimeter
		Boundable shapeMinP = null;
		// TODO: Use an "Enhanced for Loop" to find the shape with the smallest perimeter in the data ArrayList and save in shapeMinP
		System.out.println("Shape with smallest perimeter:");
		System.out.println(shapeMinP);
		System.out.println();
		
		
		// Step 7:  Write code to find the shape with the largest area
		Boundable shapeMaxA = null;
		// TODO: Use an "Enhanced for Loop" to find the shape with the largest area in the data ArrayList and save in shapeMaxA
		System.out.println("Shape with largest area:");
		System.out.println(shapeMaxA);
		System.out.println();
		
				
	}

}

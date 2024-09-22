/**
 * Triangle is an abstract class that represents a two dimensional Triangle shape. 
 */
public class Triangle extends Shape{


	// --------------------------//
	// CONSTRUCTORS
	// --------------------------//
	
	/**
	 * No-arg constructor for Triangle. 
	 */
	public Triangle(){
		super();
	}

	/**
	 * Triangle constructor taking a single size argument for Triangle.
	 * @param size 
	 */
	public Triangle(double size){
		super(size);
	}
	
	/**
	 * Triangle constructor taking width and height arguments. 
	 * @param width width of Triangle.
	 * @param height height of Triangle.
	 */
	public Triangle(double width, double height){
		super(width, height);
	}

	// --------------------------//
	// METHODS
	// --------------------------//
}

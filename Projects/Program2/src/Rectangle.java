/**
 * Rectange is a concrete class that represents a two dimenstional Rectangle
 * shape. It inherits directly from the Shape abstract class.
 */
public class Rectangle extends Shape{
		
	//--------------------------//
	// CONSTRUCTORS
	//--------------------------//
	
	
	/**
	 * No-arg constructor for Rectangle 
	 */
	public Rectangle(){
		super();
	}
	
	/**
	 * Rectangle constructor taking a single size argument for both the width and 
	 * height.
	 * @param size width and height of the Rectangle.
	 */
	public Rectangle(double size){
		super(size, size);	
	}

	/**
	 * Rectangle constructor taking width and height arguments.
	 * @param width width of the Rectangle.
	 * @param height height of the Rectangle.
	 */
	public Rectangle(double width, double height){
		super(width, height);
	}
	
	//--------------------------//
	// METHODS
	//--------------------------//
	
	@Override
	public double perimeter(){
		return 2.0*(this.width() + this.height());	
	}

	@Override
	public double area(){
		double area = this.width() * this.height();
		return area;
	}

	@Override
	public String getName(){
		return "Rectangle";
	}

}
	

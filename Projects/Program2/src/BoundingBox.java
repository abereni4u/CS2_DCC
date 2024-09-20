/**
 * The BoundingBox class is a simple concrete class that holds width 
 * and height values of a two-dimensional "bounding box" for shapes. 
 * A bounding box is the smallest 2D rectangle that will completely 
 * hold another 2D object. 
 */
public class BoundingBox {
	
	// -------------------------//
	// FIELDS
	//--------------------------//
	
	private double width;
	private double height;
	
	
	// -------------------------//
	// CONSTRUCTORS
	//--------------------------//
	
	
	/**
	 * A no-arg constructor that sets the width and height fields to 0.0.
	 */
	public BoundingBox() {
		this.width = 0.0;
		this.height = 0.0;	
	}
	
	/**
	 * A constructor that takes the width and height 
	 * of the BoundingBox as double parameters. 
	 * @param width 
	 * @param height
	 */
	public BoundingBox(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// -------------------------//
	// METHODS
	//--------------------------//
	
	/**
	 * Returns the value of the width field.
	 * @return 
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * Returns the value of the height field.
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}
	
	public double getMinDum() {
		
	}
	
	
	
}

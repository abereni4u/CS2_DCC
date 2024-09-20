/**
 * This interface specifies four methods related to aspects of a 
 * 2D object that has a bounding box or size.
 */
public abstract class Boundable {

	/**
	 * Defines the header of a method that 
	 * returns the width of a 2D Boundable object.
	 * @return the width of a 2D Boundable object
	 */
	public abstract double width();
	
	/**
	 * Defines the header of a method that 
	 * returns the height of a 2D Boundable object.
	 * @return the height of a 2D Boundable object
	 */
	public abstract double height();
	
	
	/**
	 * Defines the header of a method that returns 
	 * the perimeter of a 2D Boundable object.
	 * @return the perimeter of a 2D Boundable object
	 */
	public abstract double perimeter();
	
	/**
	 * Defines the header of a method that returns 
	 * the area of a 2D Boundable object.
	 * @return the area of a 2D Boundable object
	 */
	public abstract double area();
}

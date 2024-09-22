/**
 * The Shape class represents an “undifferentiated” or 
 * “unspecified” 2D Shape.  It is an abstract class that 
 * partially implements the Boundable interface. 
 */
public abstract class Shape implements Boundable{
	
	
	//--------------------------//
	// FIELDS
	//--------------------------//
	
	private BoundingBox boundingbox;

	
	//--------------------------//
	// CONSTRUCTORS
	//--------------------------//
	
	/**
	 * A no-arg constructor that initializes the boundingBox field with a
	 * default BoundingBox instance.
	 */
	public Shape(){
		this.boundingbox = new BoundingBox();	
	}
	
	/**
	 * Shape Constructor that initializes the boundingBox field.
	 */
	public Shape(double width, double height){
		this.boundingbox = new BoundingBox(width, height);
	}
	
	/**
	 * Shape constructor that initializes the boundingBox field using 
	 * the same value for width and height.
	 */
	public Shape(double size){
		this.boundingbox = new BoundingBox(size, size);
	}
	
	//--------------------------//
	// METHODS
	//--------------------------//
	
	/**
	 * Returns the value of the boundingBox field.
	 * @return boundingBox of the Shape instance.
	 */
	public BoundingBox getBoundingBox(){
		return this.boundingbox;
	}

	/**
	 * An abstract method that returns the name of the kind of shape.
	 * @return The name of the kind of shape.
	 */
	public abstract String getName();


	/**
	 * Returns the value returned by the boundingBox field’s 
	 * getWidth() method.
	 * @return the width of the shape.
	 */
	public double width(){
		return this.boundingbox.getWidth();	
	}

	/**
	 * Returns the value returned by the boundingBox field's
	 * getHeight() method.
	 * @return the height of the shape.
	 */
	public double height(){
		return this.boundingbox.getHeight();
	}

	/**
	 * This method will return a well-formatted String 
	 * object to be used in the shape analysis report.
	 *
	 * @return
	 */
	public String toString(){
		StringBuilder shapeReport = new StringBuilder();

		shapeReport.append(String.format("\n%-20s\n", this.getName()));
		shapeReport.append(String.format("	width: %-20.2f\n",this.width())); 
		shapeReport.append(String.format("	height: %-20.2f\n",this.height()));
		shapeReport.append(String.format("	area: %-20.2f\n",this.area()));
		shapeReport.append(String.format("	perimeter: %-20.2f\n",this.perimeter()));
		return shapeReport.toString();
	}

}

/**
 * RightTriangle is a concrete class that represents a two-dimensional
 * RightTriangle shape. It inherits directly from the Triangle abstract class.
 */
public class RightTriangle extends Triangle{


	// --------------------------//
	// CONSTRUCTORS
	// --------------------------//
	
	/**
	 * No-arg constructor for RightTriangle.
	 */
	public RightTriangle(){
		super();
	}

	/**
	 * Constructor taking a single size argument for RightTriangle.
	 * @param size 
	 */
	public RightTriangle(double size){
		super(size);
	}

	/**
	 * Constructor taking width and height arguments for RightTriangle.
	 * @param width width of RightTriangle.
	 * @param height height of RightTriangle.
	 */
	public RightTriangle(double width, double height){
		super(width, height);
	}

	
	// --------------------------//
	// METHODS
	// --------------------------//
}

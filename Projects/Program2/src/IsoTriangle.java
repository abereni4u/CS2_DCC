/**
 * IsoTriangle is a concrete class that represents a two dimensional
 * IsocelesTriangle shape. It inherits directly from the Triangle abstract
 * class.
 */
public class IsoTriangle extends RightTriangle {

	// --------------------------//
	// CONSTRUCTORS
	// --------------------------//

	/**
	 * No-arg constructor for IsoTriangle.
	 */
	public IsoTriangle() {
		super();
	}

	/**
	 * IsoTriangle single arg constructor.
	 * 
	 * @param size size of the triangle.
	 */
	public IsoTriangle(double size) {
		super(size);
	}

	/**
	 * IsoTriangle constructor that takes width and height as arguments.
	 * 
	 * @param width  width of IsoTriangle.
	 * @param height height of IsoTriangle.
	 */
	public IsoTriangle(double width, double height) {
		super(width, height);
	}

	// --------------------------//
	// METHODS
	// --------------------------//
}

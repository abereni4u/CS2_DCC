/**
 * IsoTriangle is a concrete class that represents a two dimensional
 * IsocelesTriangle shape. It inherits directly from the Triangle abstract
 * class.
 */
public class IsoTriangle extends Triangle {

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

	/**
	 * Returns the perimeter of the IsoTriangle based on the following 
	 * equation: perimeter = width + 2 (sqrt((width / 2)^2) + (height^2)).
	 */
	@Override
	public double perimeter(){
		
		// Set get width and height of triangle.
		double w = this.width();
		double h = this.height();
		
		// Inside square root: divide width by 2, square it and add it 
		// to height, squared.
		double w2 = w/2;
		double len = Math.sqrt(w2*w2 + h*h);

		double perimeter = w + (2 * len);
		return perimeter;
	}

	@Override
	public String getName(){
		return "IsoTriangle";
	}
}

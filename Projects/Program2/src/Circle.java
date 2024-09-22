
/**
 * Circle is a concrete class that represents a two-dimensional Circle.
 */
public class Circle extends Shape {

	// --------------------------//
	// CONSTRUCTORS
	// --------------------------//

	/**
	 * No-arg constructor for Circle.
	 */
	public Circle() {
		super();
	}

	/**
	 * Circle constructor that takes a single diameter argument.
	 * 
	 * @param diameter
	 */
	public Circle(double diameter) {
		super(diameter, diameter);
	}

	// --------------------------//
	// METHOD
	// --------------------------//

	/**
	 * Returns the radius of the Circle object based on the following
	 * equation: 1/2(min(w,h)).
	 * 
	 * @return radius of Circle.
	 */
	public double radius() {
		double radius = this.getBoundingBox().getMinDum() / 2;
		return radius;
	}

	/**
	 * Returns the perimeter of the Circle using the circumference formula.
	 * 
	 * @return perimeter of Circle.
	 */
	public double perimeter() {
		double perimeter = 2.0 * Math.PI * this.radius();
		return perimeter;
	}

	/**
	 * Returns the area of the Circle using the following equation:
	 * Pi * radius^2
	 * 
	 * @return area of the Circle.
	 */
	public double area() {
		double r = this.radius();
		double area = Math.PI * r * r;
		return area;
	}

	@Override
	public String getName() {
		return "Circle";
	}
}

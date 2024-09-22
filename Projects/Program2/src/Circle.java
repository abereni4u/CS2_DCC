public class Circle extends Shape{

	//--------------------------//
	// CONSTRUCTORS
	//--------------------------//

	/**
	 * No-arg constructor for Circle. 
	 */
	public Circle(){
		super();
	}

	/**
	 * Circle constructor that takes a single diameter argument.
	 * @param diameter
	 */
	public Circle (double diameter){
		super(diameter, diameter);	
	}

	//--------------------------//
	// METHOD
	//--------------------------//
}

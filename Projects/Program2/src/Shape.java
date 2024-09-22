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
	
}

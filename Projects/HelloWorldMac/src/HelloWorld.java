import java.util.ArrayList;

/**
 * 
 */

public class HelloWorld {

	/**
	 * @param This is a docstring
	 */
	public static void main(String[] args) {
		ArrayList<String> myArrayList = new ArrayList<>();
		myArrayList.add("Jane");
		myArrayList.add("Jose");
		myArrayList.add("Jose");
		myArrayList.add("Jane");
		
		ArrayList<String> names = new ArrayList<>();
	
		for(String name: myArrayList) {
			if(!names.contains(name))
				names.add(name);
		}
		
		for(String aName: myArrayList)
			System.out.println(aName);
	}
	

}
